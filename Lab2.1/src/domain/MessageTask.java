package domain;

import java.time.LocalDateTime;

public class MessageTask extends Task{

    private final String mesaj;
    private final String from;
    private final String to;
    private final LocalDateTime date;

    public MessageTask(String taskId, String desc, String mesaj, String from, String to, LocalDateTime date) {
        super(taskId, desc);
        this.mesaj = mesaj;
        this.from = from;
        this.to = to;
        this.date = date;
    }

    @Override
    public void execute() {
        System.out.println("Executat: From " + this.from + " with " + this.mesaj);
    }

    @Override
    public String toString() {
        return "MessageTask{" +
                "mesaj='" + mesaj + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", date=" + date.format(Utils.formatter) +
                '}';
    }
}
