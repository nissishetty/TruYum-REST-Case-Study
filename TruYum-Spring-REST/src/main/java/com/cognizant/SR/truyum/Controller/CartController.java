package com.cognizant.SR.truyum.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.SR.truyum.Exceptions.CartEmptyException;
import com.cognizant.SR.truyum.Exceptions.MenuItemNotFoundException;
import com.cognizant.SR.truyum.model.MenuItem;
import com.cognizant.SR.truyum.service.CartService;

@RestController
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/addCart/{userId}/{menuItemId}")
	public ResponseEntity<String> addCartItem(@PathVariable String userId, @PathVariable long menuItemId) throws MenuItemNotFoundException {
		cartService.addCartItem(userId, menuItemId);
		return ResponseEntity.status(HttpStatus.OK).body("Added Successfully menuItem = "+menuItemId+" for user id = "+userId);
	}
	
	@GetMapping("/cartItems/{userId}")
	public List<MenuItem> getAllCartItems(@PathVariable String userId)  throws CartEmptyException {
		return cartService.getAllCartItems(userId);
	}
	
	@DeleteMapping("/delete/{userId}/{menuItemId}")
	public ResponseEntity<String> removeCartItem(@PathVariable String userId, @PathVariable long menuItemId) throws MenuItemNotFoundException,CartEmptyException {
		cartService.removeCartItem(userId, menuItemId);
		return ResponseEntity.status(HttpStatus.OK).body("Deleted Successfully with menuItem = "+menuItemId+" for user id = "+userId);
	}

}
