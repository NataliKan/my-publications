package by.kanchanin.publications.dataaccess;

import by.kanchanin.publications.datamodel.Payment;

public interface PaymentDao extends AbstractDao<Long, Payment>{
	
	void confirm(Payment payment);
}
