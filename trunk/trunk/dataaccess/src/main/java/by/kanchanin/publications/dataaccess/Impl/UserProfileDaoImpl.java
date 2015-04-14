package by.kanchanin.publications.dataaccess.Impl;

import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.UserProfileDao;
import by.kanchanin.publications.datamodel.UserProfile;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class UserProfileDaoImpl extends AbstractDaoImpl<Long, UserProfile> implements UserProfileDao {

    protected UserProfileDaoImpl() {
        super(UserProfile.class);
    }

	@Override
	public Long getCount() {
	     CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();

	     CriteriaQuery<Long> criteria = cBuilder.createQuery(Long.class);
	     Root<UserProfile> root = criteria.from(UserProfile.class);

	     criteria.select(cBuilder.count(root));

	     TypedQuery<Long> query = getEm().createQuery(criteria);
	     return query.getSingleResult();
	 }
}

