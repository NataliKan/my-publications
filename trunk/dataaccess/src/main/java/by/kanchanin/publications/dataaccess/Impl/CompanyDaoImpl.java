package by.kanchanin.publications.dataaccess.Impl;

import java.util.List;



import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import by.kanchanin.publications.datamodel.Company_;
import by.kanchanin.publications.dataaccess.CompanyDao;
import by.kanchanin.publications.datamodel.Company;

@Repository
public class CompanyDaoImpl extends AbstractDaoImpl<Long, Company> implements CompanyDao {

    protected CompanyDaoImpl() {
        super(Company.class);
    }
    
    @Override
    public List<Company> getAllCompanies() {
        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();

        CriteriaQuery<Company> criteria = cBuilder.createQuery(Company.class);
        Root<Company> root = criteria.from(Company.class);

        criteria.select(root);

        TypedQuery<Company> query = getEm().createQuery(criteria);
        List<Company> results = query.getResultList();
        return results;
    }
    
    @Override
    public List<Company> getAllCompaniesByName(String name) {
        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();

        CriteriaQuery<Company> root = cBuilder.createQuery(Company.class);
        Root<Company> criteria = root.from(Company.class);

        root.select(criteria);

        root.where(cBuilder.equal(criteria.get(Company_.companyName), name));

        TypedQuery<Company> query = getEm().createQuery(root);
        List<Company> results = query.getResultList();
        return results;
    }


    
    

}
