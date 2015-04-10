package by.kanchanin.publications.services.impl;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import by.kanchanin.publications.dataaccess.PeriodicalDao;
import by.kanchanin.publications.datamodel.Periodical;


@Service
public class PeriodicalServiceImpl {
	
	@Inject
    private PeriodicalDao periodicalDao;
	
	public void createNewPeriodical(Periodical periodical) {
		Validate.isTrue(periodical.getId() == null, "This method should be called for 'not saved yet' profile only. Use UPDATE instead");
        periodical.setPeriodical(periodical);
        periodicalDao.insert(periodical);
    }
	
	public Periodical get(Long id) {
        return periodicalDao.getById(id);
    }
	
	public void updatePeriodical(Periodical periodical) {
		periodicalDao.update(periodical);
	}
	
	public void hidePeriodical(Long id) {
		periodicalDao.hideById(id);
	}
	
	public void removePeriodical(Long id) {
		periodicalDao.delete(id);
	}


}
