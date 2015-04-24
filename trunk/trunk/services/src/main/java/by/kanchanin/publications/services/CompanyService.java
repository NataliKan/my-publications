package by.kanchanin.publications.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.kanchanin.publications.datamodel.Company;


public interface CompanyService {
	
	@Transactional
    void createNewCompany(Company company);

    
    Company get(Long id);

    @Transactional
    void updateCompany(Company company);

    @Transactional
    void removeCompany(Long id);
    
    List<Company> getAllCompanies();

    List<Company> getAllCompaniesByName(String name);




}
