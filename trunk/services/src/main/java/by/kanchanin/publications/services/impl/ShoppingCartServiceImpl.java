package by.kanchanin.publications.services.impl;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import by.kanchanin.publications.dataaccess.ShoppingCartDao;
import by.kanchanin.publications.datamodel.ShoppingCart;


@Service
public class ShoppingCartServiceImpl {
	 private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartServiceImpl.class);
	
	@Inject
    private ShoppingCartDao cartDao;
	
	public ShoppingCart get(Long id) {
        return cartDao.getById(id);
    }
	
	public void addToCart(Long id) {
		 LOGGER.debug("Item addet to cart");
		cartDao.add(id);
	}
	
	public void deleteFromCart(Long id) {
		LOGGER.debug("Remove: {}", id);
		cartDao.delete(id);
	
	}
	
	public void Update(ShoppingCart cart) {
		LOGGER.debug("Update: {}", cart);
		cartDao.update(cart);
	}
	
	
    public void deleteAll() {
        LOGGER.debug("Remove all items");
        cartDao.deleteAll();
    }

}
