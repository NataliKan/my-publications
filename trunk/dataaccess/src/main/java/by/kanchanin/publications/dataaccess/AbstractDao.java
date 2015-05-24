package by.kanchanin.publications.dataaccess;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;


public interface AbstractDao<ID, Entity> {

	Entity getById(ID id);

	List<Entity> getAll();

	void deleteAll();
	
	void delete(List<ID> ids);

	
	void delete(Long id);
	
	void add(Long id);

	Entity insert(Entity entity);

	Entity update(Entity entity);
	
	Entity delete(Entity entity);
	
	List<Entity> getAllByFieldRestriction(
			SingularAttribute<? super Entity, ?> attribute, Object value,
			SingularAttribute<Entity, ?>... fetchAttributes);

	
}
