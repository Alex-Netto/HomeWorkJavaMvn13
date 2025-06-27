public class Epic extends Task {
    private String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks != null ? subtasks : new String[0];
    }

    @Override
    public boolean matches(String query) {
        if (subtasks == null) return false;
        for (String subtask : subtasks) {
            if (subtask != null && subtask.toLowerCase().contains(query)) {
                return true;
            }
        }
        return false;
    }
}
