package zadanie1;

import java.util.Map.Entry;

public class ProductService {

    private ProductDAO productDAO;

    public long findMileageByYears(Long productID, String startYear, String endYear) throws Exception {
        Car product = productDAO.findById(productID);
        long sum = 0;
        for(Entry<String, Long> entry : product.getYearMileage().entrySet()) {
            if(startYear.compareTo(entry.getKey()) <= 0 && endYear.compareTo(entry.getKey()) >= 0) {
                sum += entry.getValue();
            }
        }
        return sum;
    }

    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
}
