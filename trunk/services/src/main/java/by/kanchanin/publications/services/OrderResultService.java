package by.kanchanin.publications.services;

import org.springframework.transaction.annotation.Transactional;

import by.kanchanin.publications.datamodel.OrderResult;


public interface OrderResultService {
	

    @Transactional
    OrderResult get(Long id);

    @Transactional
    void updateOrderResult(OrderResult profile);

    @Transactional
    void removeOrderResult(Long id);

}
