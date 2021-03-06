package com.cognizant.SR.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cognizant.SR.truyum.Exceptions.CartEmptyException;
import com.cognizant.SR.truyum.Exceptions.MenuItemNotFoundException;
import com.cognizant.SR.truyum.model.Cart;
import com.cognizant.SR.truyum.model.MenuItem;
import com.cognizant.SR.truyum.service.MenuItemService;

@Repository
public class CartDaoImpl implements CartDao {
	private static Map<String, Cart> cartItems = new HashMap<>();

	@Autowired
	private MenuItemService menuItemService;

	@Override
	public void addCartItem(String userId, long menuItemId) throws MenuItemNotFoundException {
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		if (cartItems.containsKey(userId)) {
			Cart userCart = cartItems.get(userId);
			List<MenuItem> list = userCart.getMenuItemList();
			list.add(menuItem);
			userCart.setMenuItemList(list);
			userCart.setTotal(userCart.getTotal() + menuItem.getPrice());
			cartItems.put(userId, userCart);
		} else {
			Cart newCart = new Cart();
			List<MenuItem> list = new ArrayList<>();
			list.add(menuItem);
			newCart.setMenuItemList(list);
			newCart.setTotal(menuItem.getPrice());
			cartItems.put(userId, newCart);
		}
	}

	@Override
	public List<MenuItem> getAllCartItems(String userId) {

		Cart cart = cartItems.get(userId);
		return cart.getMenuItemList();
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) throws CartEmptyException, MenuItemNotFoundException {
		MenuItem item = menuItemService.getMenuItem(menuItemId);
		Cart cart = cartItems.get(userId);
		List<MenuItem> menuItemList = cart.getMenuItemList();
		menuItemList.remove(item);
		cart.setMenuItemList(menuItemList);
		cart.setTotal(cart.getTotal() - item.getPrice());
		cartItems.put(userId, cart);
		
	}

}
