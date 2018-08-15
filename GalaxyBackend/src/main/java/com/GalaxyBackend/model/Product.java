package com.GalaxyBackend.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table
public class Product 
{
@Id
@GeneratedValue
int productId;

String productName;
String productDescription;
double productPrice;

String colour;
int size;
int stock;

int categoryId;
int supplierId;

@Transient
private MultipartFile file;
private String code;

//constructor
public Product()
{
this.code="PRD"+UUID.randomUUID().toString().substring(26).toUpperCase();	
}



public String getCode() {
	return code;
}


public void setCode(String code) {
	this.code = code;
}


public MultipartFile getFile() {
	return file;
}



public void setFile(MultipartFile file) {
	this.file = file;
}



public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public int getSupplierId() {
	return supplierId;
}
public void setSupplierId(int supplierId) {
	this.supplierId = supplierId;
}
public int getProductId() {
	return productId;
}
public void setProductId(int productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}
public String getProductDescription() {
	return productDescription;
}
public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
}
public double getProductPrice() {
	return productPrice;
}
public void setProductPrice(double productPrice) {
	this.productPrice = productPrice;
}

public String getColour() {
	return colour;
}
public void setColour(String colour) {
	this.colour = colour;
}
public int getSize() {
	return size;
}
public void setSize(int size) {
	this.size = size;
}
public int getStock() {
	return stock;
}
public void setStock(int stock) {
	this.stock = stock;
}

}
