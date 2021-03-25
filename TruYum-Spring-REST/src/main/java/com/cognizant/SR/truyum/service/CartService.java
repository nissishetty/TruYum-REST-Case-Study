package com.cognizant.SR.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.SR.truyum.Exceptions.CartEmptyException;
import com.cognizant.SR.truyum.Exceptions.MenuItemNotFoundException;
import com.cognizant.SR.truyum.dao.CartDao;
import com.cognizant.SR.truyum.model.MenuItem;

@Service
public class CartService {
	
	@Autowired
	private CartDao cartDao;
	
	public void addCartItem(String userId,long menuItemId) throws MenuItemNotFoundException {
		cartDao.addCartItem(userId,menuItemId);
	}
	
	public List<MenuItem> getAllCartItems(String userId) {
		return cartDao.getAllCartItems(userId);
		
	}
	
	public void removeCartItem(String userId, long menuItemId) throws CartEmptyException, MenuItemNotFoundException {
		cartDao.removeCartItem(userId, menuItemId);
	}

}
