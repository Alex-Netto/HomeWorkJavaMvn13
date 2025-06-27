public class SimpleTask extends Task {
    protected String title;

    public SimpleTask(int id, String title) {
        super(id);
        this.title = title;
    }

    @Override
    public boolean matches(String query) {
        if (query == null || title == null) {
            return false;
        }
        return title.toLowerCase().contains(query.toLowerCase());
    }
}

