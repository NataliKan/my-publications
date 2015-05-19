package by.kanchanin.publications.dataaccess;


import by.kanchanin.publications.datamodel.Periodical;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

public interface PeriodicalDao extends AbstractDao<Long, Periodical>{
	

    Long getCount();

    List<Periodical> getAllPeriodicals();

    List<Periodical> getAllPeriodicals(SingularAttribute<Periodical, ?> attr, boolean ascending, int startRecord, int pageSize);

    List<Periodical> getAllPeriodicalsByTitle(String title);

    List<Periodical> getAllPeriodicalByPerType(String perType);

    void updatePeriodicalTitle(Long id, String newTitle);
    



}
