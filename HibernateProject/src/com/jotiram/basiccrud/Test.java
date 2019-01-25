package com.jotiram.basiccrud;

public class Test {

	public static void main(String[] args) {
		ProductClient productClient=new ProductClient();
		//Save Product
	/*	
	 * Product product=new Product();
		
		product.setProductName("Laptop");
		product.setPrice(30000.0);
		product.setBrand("Dell");
		
		System.out.println("Product Before Saveing"+product);
		
		
		product=productClient.save(product);
		System.out.println("Product After Saved:"+product);*/
		
		//Get Product By Id
		/*
		Product productById=productClient.getProductById(2);
		System.out.println("Product By id:"+productById);
		*/
		
		//Update Product
		/*
		Product productById=productClient.getProductById(2);
		System.out.println("Product By id:"+productById);
		
		productById.setBrand("Lenevo");
		productClient.update(productById);
		
		Product p=productClient.getProductById(2);
		System.out.println("Poduct After Update:"+p);
		*/
		
		//delete Product
		
		productClient.delete(2);
		
		Product productGetById=productClient.getProductById(2);
		System.out.println("Product By Id:"+productGetById);
	}
}
