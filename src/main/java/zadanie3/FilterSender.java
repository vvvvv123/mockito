package zadanie3;

import java.util.List;

public class FilterSender {

    private BrokerSender brokerSender;

    private long counter = 0L;

    public void sendSuccess(List<Message> messages) {
        for(Message message : messages) {
            if(message.getMessageStatus().equals(MessageStatusEnum.SUCCESS)) {
                counter++;
                message.setCounter(counter);
                brokerSender.send(message);
            }
        }
    }

    public void setBrokerSender(BrokerSender brokerSender) {
        this.brokerSender = brokerSender;
    }
}
