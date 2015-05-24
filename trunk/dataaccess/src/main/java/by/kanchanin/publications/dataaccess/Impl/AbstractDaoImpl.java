package by.kanchanin.publications.dataaccess.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.apache.commons.lang3.Validate;

import by.kanchanin.publications.dataaccess.AbstractDao;

public abstract class AbstractDaoImpl<ID, Entity> implements AbstractDao<ID, Entity> {
	
	private EntityManager em;
	private final Class<Entity> entityClass;

	protected AbstractDaoImpl(final Class<Entity> entityClass) {
		Validate.notNull(entityClass, "entityClass could not be a null");
		this.entityClass = entityClass;
	}

	@Override
	public Entity getById(ID id) {
		return em.find(getEntityClass(), id);
	}

	@Override
	public Entity insert(final Entity entity) {
		em.persist(entity);
		return entity;
	}

	@Override
	public Entity update(Entity entity) {
		entity = em.merge(entity);
		em.flush();
		return entity;
	}
	
	@Override
	public Entity delete(Entity entity) {
		entity = em.merge(entity);
		em.flush();
		return entity;
	}
	
	
	@Override
	public List<Entity> getAllByFieldRestriction(
			final SingularAttribute<? super Entity, ?> attribute,
			final Object value, SingularAttribute<Entity, ?>... fetchAttributes) {
		Validate.notNull(value, "Search attributes can't be empty. Attribute: "
				+ attribute.getName());
		final CriteriaBuilder cBuilder = getEm().getCriteriaBuilder();
		final CriteriaQuery<Entity> criteria = cBuilder
				.createQuery(getEntityClass());
		final Root<Entity> root = criteria.from(getEntityClass());

		criteria.select(root);
		for (SingularAttribute<Entity, ?> attr : fetchAttributes) {
			root.fetch(attr);
		}
		criteria.distinct(true);
		criteria.where(cBuilder.equal(root.get(attribute), value));
		return getEm().createQuery(criteria).getResultList();
	}


	@Override
	public void delete(List<ID> ids) {
		em.createQuery(String.format("delete from %s e where e.id in (:ids)", entityClass.getSimpleName())).setParameter("ids", ids)
				.executeUpdate();
	}
	
	@Override
	public void add(Long id) {
		em.createQuery(String.format("add to %s e where e.id in (:id)", entityClass.getSimpleName())).setParameter("id", id)
				.executeUpdate();
	}
	
	
	@Override
	public void delete(Long id) {
		em.createQuery(String.format("delete from %s e where id = (:id)", entityClass.getSimpleName())).setParameter("id", id)
				.executeUpdate();
	}

	@Override
	public void deleteAll() {
		final Query q1 = em.createQuery("delete from " + getEntityClass().getSimpleName());
		q1.executeUpdate();
		em.flush();
	}

	@Override
	public List<Entity> getAll() {
		final CriteriaQuery<Entity> query = em.getCriteriaBuilder().createQuery(getEntityClass());
		query.from(getEntityClass());
		final List<Entity> lst = em.createQuery(query).getResultList();
		return lst;
	}

	@PersistenceContext
	protected void setEntityManager(final EntityManager em) {
		this.em = em;
	}

	private Class<Entity> getEntityClass() {
		return entityClass;
	}
	
	public EntityManager getEm() {
		return em;
	}

}
