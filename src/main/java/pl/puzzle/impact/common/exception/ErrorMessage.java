package pl.puzzle.impact.common.exception;

public enum ErrorMessage {

    USER_NOT_FOUND("User not found"),
    EMAIL_NOT_FOUND("Email not found"),
    PROJECT_NOT_FOUND("Project not found"),
    TOKEN_NOT_FOUND("Token not found"),
    INCORRECT_PASSWORD("Incorrect password"),
    INVALID_TOKEN("Invalid token"),
    IMAGE_NOT_FOUND("Image not found");

    private final String message;


    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
