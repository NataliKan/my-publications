package by.kanchanin.publications.servises;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.kanchanin.publications.datamodel.ShoppingCart;
import by.kanchanin.publications.AbstractServiceTest;
import by.kanchanin.publications.services.ShoppingCartService;

public class ShoppingCartServiсeTest extends AbstractServiceTest{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartServiсeTest.class);
	
	@Inject
    private ShoppingCartService shoppingCartService;
	
	@Before
    public void cleanUpData() {
        LOGGER.info("Instance of ProductService is injected. Class is: {}", shoppingCartService.getClass().getName());
        shoppingCartService.deleteAll();
    }
	
	@Test
    public void test1() {
            LOGGER.warn("Test log message in test1().");
            Assert.assertNotNull(shoppingCartService);
    }
	
	@Test
    public void basicCRUDTest() {
		ShoppingCart shoppingCart = createShopingCart();
		shoppingCartService.update(shoppingCart);

		ShoppingCart shoppingCartFromDb = shoppingCartService.get(shoppingCart.getId());
        Assert.assertNotNull(shoppingCartFromDb);

        
        shoppingCartService.update(shoppingCartFromDb);
        ShoppingCart shoppingCartFromDbUpdated = shoppingCartService.get(shoppingCart.getId());
        

        shoppingCartService.deleteFromCart(shoppingCartFromDb);
        Assert.assertNull(shoppingCartService.get(shoppingCart.getId()));
    }
	
	


}
