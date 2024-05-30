package testRunner;

import org.testng.annotations.Test;
import pages.ProductBuyingPage;

public class ProductBuyingTestRunner extends BaseTestRunner {
    ProductBuyingPage productBuyingPage = new ProductBuyingPage();

    @Test
    public void buyProduct(){
        productBuyingPage.addingToBasket();
        productBuyingPage.addingNewAddress();
    }
}
