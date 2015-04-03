package by.kanchanin.publications.dataaccess.Impl;

import org.springframework.stereotype.Repository;

import by.kanchanin.publications.dataaccess.ShoppingCartDao;
import by.kanchanin.publications.datamodel.ShoppingCart;

@Repository
public class ShoppingCartDaoImpl extends AbstractDaoImpl<Long, ShoppingCart> implements ShoppingCartDao {

    protected ShoppingCartDaoImpl() {
        super(ShoppingCart.class);
    }

}
