package by.kanchanin.publications.dataaccess.Impl;

import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.PaymentDao;
import by.kanchanin.publications.datamodel.Payment;

@Repository
public class PaymentDaoImpl extends AbstractDaoImpl<Long, Payment> implements PaymentDao {

    protected PaymentDaoImpl() {
        super(Payment.class);
    }

	@Override
	public void confirm(Payment payment) {
		
		
	}
    

}
