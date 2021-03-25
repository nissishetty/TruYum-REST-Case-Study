package com.cognizant.SR.truyum.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.SR.truyum.Exceptions.MenuItemNotFoundException;
import com.cognizant.SR.truyum.model.MenuItem;
import com.cognizant.SR.truyum.service.MenuItemService;

@RestController
public class MenuItemController {
	
	@Autowired
	private MenuItemService menuItemService;
	
	@GetMapping("/menu-items")
	public List<MenuItem> getMenuItemListCustomer() {
		return menuItemService.getMenuItemListCustomer();

	}
	
	@GetMapping("/menu-items/{id}")
	public MenuItem getItemById(@PathVariable(value = "id") long id) throws MenuItemNotFoundException {
		return menuItemService.getMenuItem(id);
	}
	
	@PutMapping("/updateMenu")
	public ResponseEntity<String> modifyMenuItem(@RequestBody MenuItem menuItem) {
		menuItemService.modifymenu(menuItem);
		return ResponseEntity.status(HttpStatus.OK).body("New Menu Items = "+menuItem);
	}

}
