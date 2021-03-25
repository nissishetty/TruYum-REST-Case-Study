package com.cognizant.SR.truyum.dao;

import java.util.List;
import java.util.Map;

import com.cognizant.SR.truyum.Exceptions.CartEmptyException;
import com.cognizant.SR.truyum.Exceptions.MenuItemNotFoundException;
import com.cognizant.SR.truyum.model.Cart;
import com.cognizant.SR.truyum.model.MenuItem;

public interface CartDao {
	void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException;
	List<MenuItem> getAllCartItems(String userId);
	void removeCartItem(String userId, long menuItemId)  throws CartEmptyException,MenuItemNotFoundException;

}
