package by.kanchanin.publications.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.Validate;
import org.springframework.stereotype.Service;

import by.kanchanin.publications.dataaccess.ShoppingCartDao;
import by.kanchanin.publications.datamodel.ShoppingCart;
import by.kanchanin.publications.datamodel.UserProfile;
import by.kanchanin.publications.services.ShoppingCartService;


@Service
public class ShoppingCartServiceImpl {
	
	@Inject
    private ShoppingCartDao cartDao;
	
	public ShoppingCart get(Long id) {
        return cartDao.getById(id);
    }
	
	public void addToCart(ShoppingCart cart) {
		cartDao.add(ids);
	}
	
	public void deleteFromCart(ShoppingCart cart) {
		cartDao.delete();
	
	}
	
	public void saveOrUpdate(ShoppingCart cart) {
		cartDao.update(cart);
	}
	
	public void deleteAll(Long id) {
		cartDao.delete(id);
	}

}
