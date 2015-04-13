package by.kanchanin.publications.services.impl;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.kanchanin.publications.datamodel.Payment;
import by.kanchanin.publications.services.PaymentService;
import by.kanchanin.publications.dataaccess.PaymentDao;

	@Service
	public class PaymentServiceImpl implements PaymentService {
		private static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
	
	@Inject
    private PaymentDao paymentDao;
	
	public void createNewPayment(Payment payment) {
	    /*    Validate.isTrue(account.getId() == null, "This method should be called for 'not saved yet' account only. Use UPDATE instead");
	        accountDao.insert(account);*/

	        Validate.isTrue(payment.getId() == null, "This method should be called for 'not saved yet' profile only. Use UPDATE instead");
	        paymentDao.insert(payment);
	    }
	
	public Payment get(Long id) {
		return paymentDao.getById(id);
	}
	
	public void updatePayment(Payment payment) {
		paymentDao.update(payment);
	}
	
	public void cancelPayment(Payment payment) {
		LOGGER.debug("Cancel: {}", payment);
		paymentDao.cancel();
	}
	
	 public void confirmPayment(Payment payment){
		 LOGGER.debug("Confirm: {}", payment);
		 paymentDao.confirm(payment);
	 }

	@Override
	public void cancelPayment(Long id) {
		// TODO Auto-generated method stub
		
	}
	 

}

