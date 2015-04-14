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
    public void basicCRUDTest() {
		Periodical periodical = createPeriodical();
		periodicalService.updatePeriodical(periodical);

		Periodical periodicalFromDb = periodicalService.get(periodical.getId());
        Assert.assertNotNull(periodicalFromDb);
        Assert.assertEquals(periodicalFromDb.getTitle(), periodical.getTitle());
        // TODO check other fields

        periodicalFromDb.setTitle("newTitle");
        periodicalService.updatePeriodical(periodicalFromDb);
        Periodical periodicalFromDbUpdated = periodicalService.get(periodical.getId());
        Assert.assertEquals(periodicalFromDbUpdated.getTitle(), periodicalFromDb.getTitle());
        Assert.assertNotEquals(periodicalFromDbUpdated.getTitle(), periodical.getTitle());

        periodicalService.deleteAll();
        Assert.assertNull(periodicalService.get(periodical.getId()));
    }

}
