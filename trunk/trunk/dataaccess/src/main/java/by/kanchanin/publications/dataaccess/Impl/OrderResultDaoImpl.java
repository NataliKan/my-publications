package by.kanchanin.publications.dataaccess.Impl;


import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.OrderResultDao;
import by.kanchanin.publications.datamodel.OrderResult;

@Repository
public class OrderResultDaoImpl extends AbstractDaoImpl<Long, OrderResult> implements OrderResultDao{
	
	protected OrderResultDaoImpl() {
        super(OrderResult.class);
    }


}
