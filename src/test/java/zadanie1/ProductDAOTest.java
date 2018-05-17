package zadanie1;

import junit.framework.TestCase;
import org.mockito.Mock;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductDAOTest extends TestCase {

    @Mock
    private ProductDAO productDAO;

    public void setProductDAO() throws Exception{
        productDAO = mock(ProductDAO.class);
        when(productDAO.findById(12L)).thenThrow(new Exception());
    //    productDA
    }

    public void testFindById() {
    }
}