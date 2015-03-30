package by.kanchanin.publications.dataaccess;

public interface AbstractDao<ID, Entity> {
		
	Entity getById (ID id);
}
