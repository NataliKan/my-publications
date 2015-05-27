package by.kanchanin.publications.dataaccess.Impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.commons.lang3.Validate;
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
	    public void updatePeriodicalTitle(Long id, String newTitle) {
	        String q = String.format("update from %s p set p.title=:newTitleParam where p.id=:id", Periodical.class.getSimpleName());
	        Query updateQuery = getEm().createQuery(q);
	        updateQuery.setParameter("newTitleParam", newTitle);
	        updateQuery.setParameter("id", id);
	        int updatedRowsCount = updateQuery.executeUpdate();
	        Validate.isTrue(updatedRowsCount == 1, "One row should be updated");
	    }


	@Override
	public List<Periodical> getAllPeriodicals(
			SingularAttribute<Periodical, ?>... fetchAttributes) {
		final CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();
		final CriteriaQuery<Periodical> criteria = cBuilder.createQuery(Periodical.class);
		final Root<Periodical> root = criteria.from(Periodical.class);
		criteria.select(root);
		for (SingularAttribute<Periodical, ?> attr : fetchAttributes) {
			root.fetch(attr);
		}
		criteria.distinct(true);
		return getEm().createQuery(criteria).getResultList();
		
	}


	@Override
	public List<Periodical> getAllPeriodicalsByTitle(String title,
			SingularAttribute<Periodical, ?>... fetchAttributes) {
		Validate.notNull(title, "Search attributes can't be empty. Attribute: "
				+ Periodical_.title.getName());
		final CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();
		final CriteriaQuery<Periodical> criteria = cBuilder.createQuery(Periodical.class);
		final Root<Periodical> root = criteria.from(Periodical.class);
		criteria.select(root);
		for (SingularAttribute<Periodical, ?> attr : fetchAttributes) {
			root.fetch(attr);
		}
		criteria.distinct(true);
		criteria.where(cBuilder.equal(root.get(Periodical_.title), title));
		return getEm().createQuery(criteria).getResultList();
	}


	@Override
	public List<Periodical> getAllPeriodicalByPerType(String perType,
			SingularAttribute<Periodical, ?>... fetchAttributes) {
		Validate.notNull(perType, "Search attributes can't be empty. Attribute: "
				+ Periodical_.title.getName());
		final CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();
		final CriteriaQuery<Periodical> criteria = cBuilder.createQuery(Periodical.class);
		final Root<Periodical> root = criteria.from(Periodical.class);
		criteria.select(root);
		for (SingularAttribute<Periodical, ?> attr : fetchAttributes) {
			root.fetch(attr);
		}
		criteria.distinct(true);
		criteria.where(cBuilder.equal(root.get(Periodical_.perType), perType));
		return getEm().createQuery(criteria).getResultList();
		
	}


		
	


}
