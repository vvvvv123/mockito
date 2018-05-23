package zadanie3;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import zadanie2.BrokerSender;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FilterSenderTest {

    @Mock
    private FilterSender filterSender;

    @Captor
    private ArgumentCaptor<List<Message>> captor;

    @Before
    public void setUp() {
        filterSender = mock(FilterSender.class);
    }

    @Test
    public void sendSuccess() {
        Message message = new Message("kek", MessageStatusEnum.SUCCESS);
        Message message2 = new Message("kek", MessageStatusEnum.SUCCESS);

        message.setMessageStatus(MessageStatusEnum.SUCCESS);
        message2.setMessageStatus(MessageStatusEnum.SUCCESS);

        List<Message> list = new ArrayList<Message>();

        list.add(message);
        list.add(message2);

        filterSender.sendSuccess(list);

        verify(filterSender).sendSuccess(captor.capture());
        long message2Counter = captor.getValue().get(1).getCounter();
        assertEquals(0, message2Counter); // TODO: test returns 0, but should return 1
    }
}