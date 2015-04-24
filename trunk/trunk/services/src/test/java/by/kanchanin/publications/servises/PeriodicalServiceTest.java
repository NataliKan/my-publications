package by.kanchanin.publications.servises;


import java.util.List;


import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.kanchanin.publications.AbstractServiceTest;
import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.services.PeriodicalService;

public class PeriodicalServiceTest extends AbstractServiceTest{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PeriodicalServiceTest.class);
	
	@Inject
    private PeriodicalService periodicalService;
	
	@Before
    public void cleanUpData() {
        LOGGER.info("Instance of ProductService is injected. Class is: {}", periodicalService.getClass().getName());
        periodicalService.deleteAll();
    }
	
	@Test
    public void basicCreateTest() {
		Periodical periodical = createPeriodical();
		periodicalService.updatePeriodical(periodical);

		Periodical periodicalFromDb = periodicalService.get(periodical.getId());
        Assert.assertNotNull(periodicalFromDb);
        Assert.assertEquals(periodicalFromDb.getTitle(), periodical.getTitle());

        periodicalFromDb.setTitle("newTitle");
        periodicalService.updatePeriodical(periodicalFromDb);
        Periodical periodicalFromDbUpdated = periodicalService.get(periodical.getId());
        Assert.assertEquals(periodicalFromDbUpdated.getTitle(), periodicalFromDb.getTitle());
        Assert.assertNotEquals(periodicalFromDbUpdated.getTitle(), periodical.getTitle());

        periodicalService.deleteAll();
        Assert.assertNull(periodicalService.get(periodical.getId()));
    }
	
	@Test
    public void searchTest() {
		Periodical periodical = createPeriodical();
		periodicalService.updatePeriodical(periodical);

        List<Periodical> allPeriodical = periodicalService.getAllPeriodicals();
        Assert.assertEquals(allPeriodical.size(), 1);

    }
	
	@Test
    public void searchByTitleTest() {
		Periodical periodical = createPeriodical();
        String title = randomString("title-");
        periodical.setTitle(title);
        periodicalService.updatePeriodical(periodical);

        Periodical anotherPeriodical = createPeriodical();
        periodicalService.updatePeriodical(anotherPeriodical);

        List<Periodical> allProduct = periodicalService.getAllPeriodicals();
        Assert.assertEquals(allProduct.size(), 2);

        List<Periodical> allPeriodicalByTitle = periodicalService.getAllPeriodicalsByTitle(title);
        Assert.assertEquals(allPeriodicalByTitle.size(), 1);
        Assert.assertEquals(allPeriodicalByTitle.get(0).getId(), periodical.getId());

    }
	
	


}
