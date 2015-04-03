package by.kanchanin.publications.dataaccess.Impl;

import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.CompanyDao;
import by.kanchanin.publications.datamodel.Company;

@Repository
public class CompanyDaoImpl extends AbstractDaoImpl<Long, Company> implements CompanyDao {

    protected CompanyDaoImpl() {
        super(Company.class);
    }

}
