package by.kanchanin.publications.services.impl;

import javax.inject.Inject;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.kanchanin.publications.dataaccess.PeriodicalDao;
import by.kanchanin.publications.datamodel.Periodical;


@Service
public class PeriodicalServiceImpl {
	 private static final Logger LOGGER = LoggerFactory.getLogger(PeriodicalServiceImpl.class);
	
	@Inject
    private PeriodicalDao periodicalDao;
	
	@PostConstruct
    private void init() {
        // this method will be called by Spring after bean instantiation. Can be
        // used for any initialization process.
        LOGGER.info("Instance of PeriodicalService is created. Class is: {}", getClass().getName());
    }
	
	public void createNewPeriodical(Periodical periodical) {
        periodicalDao.insert(periodical);
    }
	
	public Periodical get(Long id) {
		Periodical entity = periodicalDao.getById(id);
	        return entity;
    }
	
	public void updatePeriodical(Periodical periodical) {
		periodicalDao.update(periodical);
	}
	
	
	public void removePeriodical(Long id) {
		periodicalDao.delete(id);
	}


}
