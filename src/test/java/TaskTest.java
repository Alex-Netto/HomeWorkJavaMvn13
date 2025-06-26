import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TaskTest {

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Позвонить");

        Assertions.assertTrue(actual);
    }

    @Test
    public void testSimpleTaskNotMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        boolean actual = simpleTask.matches("Написать");

        Assertions.assertFalse(actual);
    }

        @Test
        void testEquals() {
            Task task1 = new Task(1);
            Task task2 = new Task(1);
            Task task3 = new Task(2);

            assertEquals(task1, task2);
            assertNotEquals(task1, task3);
            assertNotEquals(task1, null);
            assertNotEquals(task1, new Object());
        }

        @Test
        void testHashCode() {
            Task task1 = new Task(1);
            Task task2 = new Task(1);

            assertEquals(task1.hashCode(), task2.hashCode());
        }

        @Test
        void testMatches() {
            Task task = new Task(1);
            assertFalse(task.matches("any"));
        }
    }


