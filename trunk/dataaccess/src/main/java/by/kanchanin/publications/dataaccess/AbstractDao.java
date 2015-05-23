package by.kanchanin.publications.dataaccess;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;


public interface AbstractDao<ID, Entity> {

	Entity getById(ID id);

	List<Entity> getAll();

	void deleteAll();
	
	void delete(List<ID> ids);
	
	List<Entity> getAllByFieldRestriction(final SingularAttribute<? super Entity, ?> attribute, final Object value);
	
	void delete(Long id);
	
	void add(Long id);

	Entity insert(Entity entity);

	Entity update(Entity entity);
	
	Entity delete(Entity entity);
	
	
	
}
