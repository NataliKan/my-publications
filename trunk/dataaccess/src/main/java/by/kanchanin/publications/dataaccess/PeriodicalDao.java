package by.kanchanin.publications.dataaccess;


import by.kanchanin.publications.datamodel.Periodical;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

public interface PeriodicalDao extends AbstractDao<Long, Periodical>{
	

    List<Periodical> getAllPeriodicals(SingularAttribute<Periodical, ?>... fetchAttributes);

    List<Periodical> getAllPeriodicalsByTitle(String title,
			SingularAttribute<Periodical, ?>... fetchAttributes);

    List<Periodical> getAllPeriodicalByPerType(String perType,
			SingularAttribute<Periodical, ?>... fetchAttributes);

    void updatePeriodicalTitle(Long id, String newTitle);
    



}
