package com.cognizant.SR.truyum.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.event.MenuListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.SR.truyum.Exceptions.MenuItemNotFoundException;
import com.cognizant.SR.truyum.model.MenuItem;

@Repository
public class MenuItemDaoCollectionImpl implements MenuItemDao{
	private static List<MenuItem> MENUITEM_LIST = new ArrayList<>();
	
	public MenuItemDaoCollectionImpl() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("truyum.xml");
		MENUITEM_LIST = (List<MenuItem>) ctx.getBean("menuitem_list");
	}

	
	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		return MENUITEM_LIST;
	}


	
	@Override
	public MenuItem getMenuItemById(long id) throws MenuItemNotFoundException {
		for(MenuItem item : MENUITEM_LIST) {
			if (id == item.getId()) {
				return item;
			}
		}
		throw new MenuItemNotFoundException("MenuItem not found");
	}


	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		try {
			MenuItem item = getMenuItemById(menuItem.getId());
			item.setName(menuItem.getName());
			item.setCategory(menuItem.getCategory());
			item.setPrice(menuItem.getPrice());
			item.setActive(menuItem.isActive());
			item.setFreeDelivery(menuItem.isFreeDelivery());
			item.setDateOfLaunch(menuItem.getDateOfLaunch());
		} catch (MenuItemNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
