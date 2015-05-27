package by.kanchanin.publications.servises;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import org.hibernate.LazyInitializationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.kanchanin.publications.AbstractServiceTest;
import by.kanchanin.publications.datamodel.OrderResult;
import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.services.OrderResultService;


public class OrderResultServiceTest extends AbstractServiceTest{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderResultServiceTest.class);

    @Inject
    private OrderResultService orderResultService;
	
    @Before
    public void cleanUpData() {
        LOGGER.info("Instance of ProductService is injected. Class is: {}", orderResultService.getClass().getName());
        orderResultService.removeOrderResult(null);
    }
    
    @Test
    public void basicCreateTest() {
		OrderResult orderResult = createOrderResult();
		orderResultService.updateOrderResult(orderResult);

		OrderResult orderResultFromDb = orderResultService.get(orderResult.getId());
        Assert.assertNotNull(orderResultFromDb);
       
        

    
    
    
    
    }
}
