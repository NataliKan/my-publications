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
import by.kanchanin.publications.datamodel.Company;
import by.kanchanin.publications.services.CompanyService;


public class CompanyServiceTest extends AbstractServiceTest{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CompanyServiceTest.class);

    @Inject
    private CompanyService companyService;
    
    @Before
    public void cleanUpData() {
        LOGGER.info("Instance of ProductService is injected. Class is: {}", companyService.getClass().getName());
        companyService.removeCompany(null);
    }
    
    @Test
    public void basicCRUDTest() {
    	Company company = createCompany();
    	companyService.updateCompany(company);

    	Company companyFromDb = companyService.get(company.getId());
        Assert.assertNotNull(companyFromDb);
        Assert.assertEquals(companyFromDb.getCompanyName(), company.getCompanyName());
        // TODO check other fields

        companyFromDb.setCompanyName("newName");
        companyService.updateCompany(companyFromDb);
        Company companyFromDbUpdated = companyService.get(company.getId());
        Assert.assertEquals(companyFromDbUpdated.getCompanyName(), companyFromDb.getCompanyName());
        Assert.assertNotEquals(companyFromDbUpdated.getCompanyName(), company.getCompanyName());

        companyService.removeCompany(companyFromDbUpdated);
        Assert.assertNull(companyService.get(company.getId()));
    }


}
