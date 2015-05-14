package by.kanchanin.publications.services.impl;

import java.util.Arrays;
import java.util.List;

import by.kanchanin.publications.datamodel.OrderResult;
import by.kanchanin.publications.datamodel.enums.OrderStatus;


import javax.inject.Inject;

import org.springframework.stereotype.Service;

import by.kanchanin.publications.dataaccess.OrderResultDao;
import by.kanchanin.publications.services.OrderResultService;

	@Service
	public class OrderResultServiceImpl implements OrderResultService{
		

		@Inject
	    private OrderResultDao orderResultDao;
		
		public OrderResult get(Long id) {
			return orderResultDao.getById(id);
		}
		
		public void updateOrderResult(OrderResult orderResult) {
			orderResultDao.update(orderResult);
		}
		
		public  void removeOrderResult(Long id) {
			orderResultDao.delete(id);
		}

		@Override
		public List<OrderStatus> getStatus(Long orderId) {
			// FIXME replace with call to DB
			return Arrays.asList(OrderStatus.succeeded);
		}
		
		
}
