package by.kanchanin.publications.services;

import org.springframework.transaction.annotation.Transactional;

import by.kanchanin.publications.datamodel.ShoppingCart;

public interface ShoppingCartService {
	
	
	@Transactional
	ShoppingCart get(Long id);
	
	@Transactional
	void addToCart(Long id);
	
	@Transactional
	void deleteFromCart(ShoppingCart cart);
	
	@Transactional
	void update(ShoppingCart cart);
	
	@Transactional
	void deleteAll(Long id);

}
