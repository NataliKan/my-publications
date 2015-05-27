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
        LOGGER.info("Instance of PeriodicalService is injected. Class is: {}", periodicalService.getClass().getName());
        periodicalService.deleteAll();
    }
	
	@Test
    public void basicCreateTest() {
		Periodical periodical = createPeriodical();
		periodicalService.updatePeriodical(periodical);

		Periodical periodicalFromDb = periodicalService.get(periodical.getId());
        Assert.assertNotNull(periodicalFromDb);
        Assert.assertEquals(periodicalFromDb.getTitle(), periodical.getTitle());
        Assert.assertEquals(periodicalFromDb.getPerType(), periodical.getPerType());
        Assert.assertEquals(periodicalFromDb.getDateOfIssue(), periodical.getDateOfIssue());
        Assert.assertEquals(periodicalFromDb.getCompany(), periodical.getCompany());
        Assert.assertEquals(periodicalFromDb.getPrice(), periodical.getPrice());
        Assert.assertEquals(periodicalFromDb.getAvailable(), periodical.getAvailable());
        

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
		String title = periodical.getTitle();
		periodicalService.updatePeriodical(periodical);

		Periodical anotherPeriodical = createPeriodical();
		periodicalService.updatePeriodical(anotherPeriodical);

		List<Periodical> allPeriodicals = periodicalService.getAllPeriodicals();
		Assert.assertEquals(allPeriodicals.size(), 2);

		List<Periodical> allPeriodicalsByTitle = periodicalService.getAllPeriodicalsByTitle(title);
		Assert.assertEquals(allPeriodicalsByTitle.size(), 1);
		Assert.assertEquals(allPeriodicalsByTitle.get(0).getId(), periodical.getId());

	}

	@Test
	public void searchByPerTypeTest() {
		Periodical periodical = createPeriodical();
		String perType = periodical.getPerType();
		periodicalService.updatePeriodical(periodical);

		Periodical anotherPeriodical = createPeriodical();
		periodicalService.updatePeriodical(anotherPeriodical);

		List<Periodical> allPeriodicals = periodicalService.getAllPeriodicals();
		Assert.assertEquals(allPeriodicals.size(), 2);

		List<Periodical> allPeriodicalsByPerType = periodicalService.getAllPeriodicalsByPerType(perType);
		Assert.assertEquals(allPeriodicalsByPerType.size(), 1);
		Assert.assertEquals(allPeriodicalsByPerType.get(0).getId(), periodical.getId());

	}
	
	


}
