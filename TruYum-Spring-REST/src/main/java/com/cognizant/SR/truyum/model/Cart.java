package com.cognizant.SR.truyum.model;

import java.util.List;

import lombok.Data;

@Data
public class Cart {
	private List<MenuItem> menuItemList;
	private double total;

}
