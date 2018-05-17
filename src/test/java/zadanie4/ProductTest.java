package zadanie4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductTest {
    @Mock
    private Product productMock;

    @Spy
    private Product productSpy;

    @Test
    public void testMockList() {
        //by default, calling the methods of mock object will do nothing
        productMock.setId(12L);
        assertSame(productMock.getId(), 0L);
    }

    @Test
    public void testSpyList() {
        //spy object will call the real method when not stub
        productSpy.setId(12L);
        assertSame(12L, productSpy.getId());
    }

    @Test
    public void testMockWithStub() {
        //try stubbing a method
        when(productMock.getId()).thenReturn(12L);

        assertSame(productMock.getId(), 12L);
    }

    @Test
    public void testSpyWithStub() {
        //stubbing a spy method will result the same as the mock object
        doReturn(12L).when(productSpy).getId();

        assertSame(12L, productSpy.getId());
    }
}