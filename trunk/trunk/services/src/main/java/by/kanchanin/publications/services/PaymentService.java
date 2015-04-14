package by.kanchanin.publications.services;

import org.springframework.transaction.annotation.Transactional;


import by.kanchanin.publications.datamodel.Payment;

public interface PaymentService {
	
	@Transactional
    void createNewPayment(Payment payment);

    @Transactional
    Payment get(Long id);

    @Transactional
    void updatePayment(Payment payment);

    @Transactional
    void cancelPayment(Long id);
    
    @Transactional
    void confirmPayment(Payment payment);

}
