package pl.puzzle.impact.common.model;

public enum EntityType {

    COMPANY("company"),
    PROJECT("project"),
    EVENT("event");

    private final String message;


    EntityType(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
