public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String time;

    public Meeting(int id, String topic, String project, String time) {
        super(id);
        this.topic = topic;
        this.project = project;
        this.time = time;


    }
    @Override
public boolean matches(String query) {
    return (topic != null && topic.toLowerCase().contains(query)) ||
            (project != null && project.toLowerCase().contains(query));
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
}