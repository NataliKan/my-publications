package by.kanchanin.publications.services.impl;

import java.util.List;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

import by.kanchanin.publications.dataaccess.CompanyDao;
import by.kanchanin.publications.datamodel.Company;
import by.kanchanin.publications.services.CompanyService;

	@Service
	public class CompanyServiceImpl implements CompanyService{
		
		
		@Inject
	    private CompanyDao companyDao;
		
		public  void createNewCompany(Company company) {
			Validate.isTrue(company.getId() == null, "This method should be called for 'not saved yet' profile only. Use UPDATE instead");
			companyDao.insert(company);
		}
		
		public Company get(Long id) {
			return companyDao.getById(id);
		}
		
		public void updateCompany(Company company) {
			companyDao.update(company);
		}
		
		public void removeCompany(Company company) {
			companyDao.delete(company);
		}
		

		
		public List<Company> getAllProducts() {
	        return companyDao.getAllCompanies();

	    }

	    @Override
	    public List<Company> getAllCompaniesByName(String name) {
	        return companyDao.getAllCompaniesByName(name);
	    }

		@Override
		public List<Company> getAllCompanies() {
			return companyDao.getAllCompanies();
		}

		@Override
		public void removeCompany(Long id) {
			// TODO Auto-generated method stub
			
		}
	
	

}
