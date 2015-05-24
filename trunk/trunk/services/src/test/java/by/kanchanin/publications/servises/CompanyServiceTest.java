package by.kanchanin.publications.servises;



import javax.inject.Inject;

import org.junit.After;
import org.junit.Assert;
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
    
    private Long id;
    
    @After
    public void cleanUpData() {
        LOGGER.info("Instance of ProductService is injected. Class is: {}", companyService.getClass().getName());
        companyService.removeCompany(id);
    }
    
    @Test
    public void basicCRUDTest() {
    	Company company = createCompany();
    	companyService.updateCompany(company);
    	id = company.getId();
    	Company companyFromDb = companyService.get(company.getId());
        Assert.assertNotNull(companyFromDb);
        Assert.assertEquals(companyFromDb.getCompanyName(), company.getCompanyName());

        companyFromDb.setCompanyName("newName");
        companyService.updateCompany(companyFromDb);
        Company companyFromDbUpdated = companyService.get(company.getId());
        Assert.assertEquals(companyFromDbUpdated.getCompanyName(), companyFromDb.getCompanyName());
        Assert.assertNotEquals(companyFromDbUpdated.getCompanyName(), company.getCompanyName());

        companyService.removeCompany(id);
        Assert.assertNull(companyService.get(company.getId()));
    }
    
    @Test
    public void getAllCompaniesByNameTest () {
    	
    }
    
    
    
    
    
    


}
