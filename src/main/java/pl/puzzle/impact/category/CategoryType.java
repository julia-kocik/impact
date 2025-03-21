package pl.puzzle.impact.category;

public enum CategoryType {

    DIVERSITY("diversity"),
    EQUALITY("equality"),
    INCLUSION("inclusion");

    private final String message;


    CategoryType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
