package pl.puzzle.impact.comment;

public enum CommentEntityType {
    PROJECT("project"),
    COMPANY("company");

    private final String message;


    CommentEntityType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
