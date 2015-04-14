package by.kanchanin.publications.dataaccess.Impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.commons.lang3.Validate;
import org.hibernate.jpa.criteria.OrderImpl;
import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.PeriodicalDao;
import by.kanchanin.publications.datamodel.Periodical;
import by.kanchanin.publications.datamodel.Periodical_;

@Repository
public class PeriodicalDaoImpl extends AbstractDaoImpl<Long, Periodical> implements PeriodicalDao{
	
	 protected PeriodicalDaoImpl() {
	        super(Periodical.class);
	    }
	 
	 @Override
	    public Long getCount() {
	        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();

	        CriteriaQuery<Long> criteria = cBuilder.createQuery(Long.class);
	        Root<Periodical> root = criteria.from(Periodical.class);

	        criteria.select(cBuilder.count(root));

	        TypedQuery<Long> query = getEm().createQuery(criteria);
	        return query.getSingleResult();
	    }
	 
	 
	 @Override
	    public List<Periodical> getAllPeriodicals() {
	        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();

	        CriteriaQuery<Periodical> criteria = cBuilder.createQuery(Periodical.class);
	        Root<Periodical> root = criteria.from(Periodical.class);

	        criteria.select(root);

	        TypedQuery<Periodical> query = getEm().createQuery(criteria);
	        List<Periodical> results = query.getResultList();
	        return results;
	    }
	 
	 @Override
	    public List<Periodical> getAllPeriodicals(SingularAttribute<Periodical, ?> attr, boolean ascending, int startRecord, int pageSize) {
	        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();

	        CriteriaQuery<Periodical> criteria = cBuilder.createQuery(Periodical.class);
	        Root<Periodical> root = criteria.from(Periodical.class);

	        criteria.select(root);
	        criteria.orderBy(new OrderImpl(root.get(attr), ascending));

	        TypedQuery<Periodical> query = getEm().createQuery(criteria);
	        query.setFirstResult(startRecord);
	        query.setMaxResults(pageSize);

	        List<Periodical> results = query.getResultList();
	        return results;
	    }
	 
	 @Override
	    public List<Periodical> getAllPeriodicalsByTitle(String title) {
	        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();

	        CriteriaQuery<Periodical> root = cBuilder.createQuery(Periodical.class);
	        Root<Periodical> criteria = root.from(Periodical.class);

	        root.select(criteria);

	        root.where(cBuilder.equal(criteria.get(Periodical_.title), title));

	        TypedQuery<Periodical> query = getEm().createQuery(root);
	        List<Periodical> results = query.getResultList();
	        return results;
	    }
	 
	
	 
	 @Override
	    public List<Periodical> getAllPeriodicalByPerType(String perType) {
	        CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();

	        CriteriaQuery<Periodical> root = cBuilder.createQuery(Periodical.class);
	        Root<Periodical> criteria = root.from(Periodical.class);

	        root.select(criteria);

	        root.where(cBuilder.equal(criteria.get(Periodical_.perType), perType));

	        TypedQuery<Periodical> query = getEm().createQuery(root);
	        List<Periodical> results = query.getResultList();
	        return results;
	    }
	 
	 @Override
	    public void updatePeriodicalTitle(Long id, String newTitle) {
	        String q = String.format("update from %s p set p.title=:newTitleParam where p.id=:id", Periodical.class.getSimpleName());
	        Query updateQuery = getEm().createQuery(q);
	        updateQuery.setParameter("newTitleParam", newTitle);
	        updateQuery.setParameter("id", id);
	        int updatedRowsCount = updateQuery.executeUpdate();
	        Validate.isTrue(updatedRowsCount == 1, "One row should be updated");
	    }
}
