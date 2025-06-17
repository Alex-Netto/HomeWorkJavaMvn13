import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();

        todos.add(simpleTask);
        String query = "Позвонить родителям";

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchMeetings() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Todos todos = new Todos();

        todos.add(meeting);
        String query = "Выкатка 3й версии приложения";

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchIfSeveralSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(2, "Позвонить сыну");
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        String query = "Позвонить сыну";

        Task[] expected = {simpleTask2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchIfSeveralMeetings() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );
        Meeting meeting2 = new Meeting(
                123,
                "Выкатка 1-й версии приложения",
                "Приложение T-Банка",
                "В четверг утром"
        );
        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(meeting2);
        String query = "Выкатка 1-й версии приложения";

        Task[] expected = {meeting2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchIfNoSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();

        todos.add(simpleTask);
        String query = "Позвонить отцу";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchIfNoMeetings() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        String query = "Выкатка 4й версии приложения";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchIfNoEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};

        Epic epic = new Epic(55, subtasks);

        Todos todos = new Todos();

        todos.add(epic);
        todos.add(epic);
        String query = "мясо";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchSeveralSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(2, "Позвонить сыну");
        SimpleTask simpleTask3 = new SimpleTask(7, "Позвонить другу");
        SimpleTask simpleTask4 = new SimpleTask(12, "Прочитать книгу");
        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(simpleTask4);
        String query = "Позвонить";

        Task[] expected = {simpleTask, simpleTask2, simpleTask3};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);
        Todos todos = new Todos();

        todos.add(epic);
        String query = "Хлеб";

        Task[] expected = {epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchIfSeveralEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        String[] subtasks2 = {"Сыр", "Батон", "Масло"};
        Epic epic = new Epic(55, subtasks);
        Epic epic2 = new Epic(11, subtasks2);
        Todos todos = new Todos();

        todos.add(epic);
        todos.add(epic2);
        String query = "Масло";

        Task[] expected = {epic2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
}
