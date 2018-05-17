package zadanie2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class BrokerSenderTest {

    @Mock
    private BrokerSender brokerSender;

    @Before
    public void setUp() {
        brokerSender = mock(BrokerSender.class);
    }

    @Test(expected = Exception.class)
    public void send() throws Exception {
        doThrow(new Exception()).when(brokerSender).send(anyString()); // TODO:: try to change it to "when().thenThrow()"
        brokerSender.send("Lol");
    }

}