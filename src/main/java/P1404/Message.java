package P1404;

public class Message {
    int id;
    String message;

    public Message(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public String toString(){
        return id + ": " + message;
    }

}

