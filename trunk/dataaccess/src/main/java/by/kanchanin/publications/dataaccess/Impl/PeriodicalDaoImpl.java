package by.kanchanin.publications.dataaccess.Impl;

import by.kanchanin.publications.dataaccess.PeriodicalDao;
import by.kanchanin.publications.datamodel.Periodical;

public class PeriodicalDaoImpl extends AbstractDaoImpl<Long, Periodical> implements PeriodicalDao{
	
	 protected PeriodicalDaoImpl() {
	        super(Periodical.class);
	    }
	 
	 

}
