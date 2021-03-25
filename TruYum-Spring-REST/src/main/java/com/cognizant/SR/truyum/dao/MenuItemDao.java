package com.cognizant.SR.truyum.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.SR.truyum.Exceptions.MenuItemNotFoundException;
import com.cognizant.SR.truyum.model.MenuItem;


public interface MenuItemDao {
	
	List<MenuItem> getMenuItemListCustomer();
	MenuItem getMenuItemById(long id) throws MenuItemNotFoundException;
	void modifyMenuItem(MenuItem menuItem);

}
