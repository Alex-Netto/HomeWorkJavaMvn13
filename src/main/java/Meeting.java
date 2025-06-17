public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String time;

    public Meeting(int id, String topic, String project, String time) {
        super(id); // вызов родительского конструктора
        this.topic = topic; // заполнение своих полей
        this.project = project;
        this.time = time;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getTime() {
        return time;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

}
