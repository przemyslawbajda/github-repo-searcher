package prj.reposearcher.reposearcher.exceptions;

public class ErrorMessage {

    private final String status;
    private final String message;

    public ErrorMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
