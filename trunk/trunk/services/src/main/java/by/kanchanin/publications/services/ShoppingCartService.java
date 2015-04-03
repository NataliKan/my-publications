package by.kanchanin.publications.services;

import org.springframework.transaction.annotation.Transactional;

import by.kanchanin.publications.datamodel.ShoppingCart;

public interface ShoppingCartService {
	
	@Transactional
	void createNewOrder(ShoppingCart shoppingCart);
	
	@Transactional
	ShoppingCart get(Long id);
	
	@Transactional
	void removeFromCart();
	
	@Transactional
	void updateShoppingCart();
	
	@Transactional
	void removeAll(Long id);

}
