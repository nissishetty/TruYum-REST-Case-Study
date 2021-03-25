package com.cognizant.SR.truyum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.SR.truyum.Exceptions.MenuItemNotFoundException;
import com.cognizant.SR.truyum.dao.MenuItemDao;
import com.cognizant.SR.truyum.model.MenuItem;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemDao menuItemDao;
	
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemDao.getMenuItemListCustomer();
		
	}
	
	public MenuItem getMenuItem(long id) throws MenuItemNotFoundException {
		return menuItemDao.getMenuItemById(id);
		
	}
	
	public void modifymenu(MenuItem item) {
		menuItemDao.modifyMenuItem(item);
	}
}
