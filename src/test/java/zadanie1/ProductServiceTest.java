package zadanie1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import java.util.HashMap;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProductServiceTest {

    private ProductService productService;

    @Mock
    private ProductDAO productDAO;
    private Car car;

    @Before
    public void setUp() {
        setProductDAO();
        setProductService();
        setCar();
    }

    @Test
    public void testFindMileageByYears() throws Exception {
        when(productDAO.findById(1L)).thenReturn(car);

        when(car.getYearMileage()).thenReturn(new HashMap<String, Long>() {{
            put("12", 123L);
            put("13", 2L);
        }});
        Assert.assertSame(productService.findMileageByYears(1L, "12", "15"), 125L);

        when(car.getYearMileage()).thenReturn(new HashMap<String, Long>() {{
            put("1", 1L);
            put("3", 2L);
        }});
        Assert.assertSame(productService.findMileageByYears(1L, "12", "15"), 0L);

        when(car.getYearMileage()).thenReturn(new HashMap<String, Long>() {{
            put("13", 1L);
            put("3", 2L);
        }});
        Assert.assertSame(productService.findMileageByYears(1L, "12", "15"), 1L);
    }

    private void setProductDAO() {
        productDAO = mock(ProductDAO.class);
    }

    private void setProductService() {
        productService = new ProductService();
        productService.setProductDAO(productDAO);
    }

    private void setCar() {
        car = mock(Car.class);
        car.setId(1L);
    }

}