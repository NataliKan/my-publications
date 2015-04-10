package by.kanchanin.publications.services;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import by.kanchanin.publications.datamodel.Periodical;

public interface PeriodicalServise {
	
	@Transactional
    void createNewPeriodical(Periodical periodical);

    @Transactional
    Periodical get(Long id);
    
    @Transactional
    void updatePeriodical(Periodical periodical);

    @Transactional
    void hidePeriodical(Periodical profile);

    @Transactional
    void removePeriodical(Long id);
    
    @Transactional
    void deleteAll();

    List<Periodical> getAllPeriodicals();

    List<Periodical> getAllPeriodicalsByTitle(String title);
    
    List<Periodical> getAllPeriodicalByPerType(String perType);

}


