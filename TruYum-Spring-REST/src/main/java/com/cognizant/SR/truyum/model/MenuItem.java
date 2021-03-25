package com.cognizant.SR.truyum.model;

import java.util.Date;

import lombok.Data;

@Data
public class MenuItem {
	private long id;
	private String name;
	private float price;
	private boolean active;
	private Date dateOfLaunch;
	private String category;
	private boolean freeDelivery;

}
