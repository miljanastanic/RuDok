package app.eventHandler;

public class Error {

    int type;
    String message;
    String title;

    public Error(int type, String message, String title) {
        this.type = type;
        this.message= message;
        this.title=title;
    }

    public int getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }
}