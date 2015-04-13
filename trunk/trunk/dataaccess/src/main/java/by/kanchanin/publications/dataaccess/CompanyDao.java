package by.kanchanin.publications.dataaccess;

import java.util.List;

import by.kanchanin.publications.datamodel.Company;

public interface CompanyDao extends AbstractDao<Long, Company>{
	
	 List<Company> getAllCompanies();

	    List<Company> getAllCompaniesByName(String name);

}
