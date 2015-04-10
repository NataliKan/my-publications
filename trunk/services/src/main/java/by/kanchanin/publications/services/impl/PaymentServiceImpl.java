package by.kanchanin.publications.services.impl;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import by.kanchanin.publications.datamodel.Payment;
import by.kanchanin.publications.services.PaymentService;
import by.kanchanin.publications.dataaccess.PaymentDao;

	@Service
	public class PaymentServiceImpl implements PaymentService {
	
	@Inject
    private PaymentDao paymentDao;
	
	public void createNewPayment(Payment payment) {
	    /*    Validate.isTrue(account.getId() == null, "This method should be called for 'not saved yet' account only. Use UPDATE instead");
	        accountDao.insert(account);*/

	        Validate.isTrue(payment.getId() == null, "This method should be called for 'not saved yet' profile only. Use UPDATE instead");
	        payment.setPayment(payment);
	        paymentDao.insert(payment);
	    }
	
	public Payment get(Long id) {
		return paymentDao.getById(id);
	}
	
	public void updatePayment(Payment payment) {
		paymentDao.update(payment);
	}
	
	public void cancelPayment(Long id) {
		paymentDao.cancel(id);
	}
	
	 public void confirmPayment(Payment payment){
		 paymentDao.confirm();
	 }

}

