package by.kanchanin.publications.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.kanchanin.publications.datamodel.OrderResult;
import by.kanchanin.publications.datamodel.enums.OrderStatus;


public interface OrderResultService {
	

    @Transactional
    OrderResult get(Long id);

    @Transactional
    void updateOrderResult(OrderResult profile);

    @Transactional
    void removeOrderResult(Long id);
    
    List<OrderStatus> getStatus(Long orderId);

}
