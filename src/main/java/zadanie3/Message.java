package zadanie3;

public class Message {

    private String text;

    private MessageStatusEnum messageStatus;

    private long counter;

    public Message(String text, MessageStatusEnum messageStatus) {
        this.text = text;
        this.messageStatus = messageStatus;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setMessageStatus(MessageStatusEnum messageStatus) {
        this.messageStatus = messageStatus;
    }

    public MessageStatusEnum getMessageStatus() {
        return messageStatus;
    }

    public void setCounter(long counter) {
        this.counter = counter;
    }

    public long getCounter() {
        return counter;
    }
}
