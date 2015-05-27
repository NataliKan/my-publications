package by.kanchanin.publications.services;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.persistence.metamodel.SingularAttribute;

import by.kanchanin.publications.datamodel.Periodical;

public interface PeriodicalService {
	
	@Transactional
    void createNewPeriodical(Periodical periodical);

    @Transactional
    Periodical get(Long id);
    
    @Transactional
    void updatePeriodical(Periodical periodical);


    @Transactional
    void removePeriodical(Periodical periodical);
    
    @Transactional
    void deleteAll();

    List<Periodical> getAllPeriodicalsByTitle(String title);
    
    List<Periodical> getAllPeriodicalsByPerType(String perType);

	List<Periodical> getAllPeriodicals();

	String getRootFolder();
  



}


