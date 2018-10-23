package com.logitech.operationmart.models;


import java.util.*;

import com.logitech.operationmart.beans.Product;

public class ProductModel {

	
	public List<Product> findAll(){
		
		List<Product> products = new ArrayList<Product>();
		products.add(new Product("910", "Mouse", 		100,	1));
		products.add(new Product("911", "Keyboard", 	200,	2));
		products.add(new Product("912", "Screenguard", 	300,	3));
		products.add(new Product("913", "Bluetooth", 	400,	4));
		products.add(new Product("914", "Wifi", 		500,	5));
		products.add(new Product("915", "USBStick", 	600,	6));
		products.add(new Product("916", "WebCam", 		700,	7));
		products.add(new Product("917", "Joystick", 	800,	8));
		products.add(new Product("918", "CD-Rom", 		900,	9));
		products.add(new Product("919", "Printer", 		110,	10));
		products.add(new Product("920", "Scanner", 		120,	11));
		
		return products;
	}
	
}
