package com.GalaxyBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Supplier 
{
@Id
@GeneratedValue
int supplier_Id;

String supplier_Name;
String pan_No;
String aadhar_No;
String email;
String mobile;
String gstin_No;
String supplier_Company_Name;
int quantity;

public int getSupplierId() 
{
	return supplier_Id;
}

public void setSupplierId(int supplierId) 
{
	this.supplier_Id = supplierId;
}

public String getSupplierName() 
{
	return supplier_Name;
}

public void setSupplierName(String supplierName) 
{
	this.supplier_Name = supplierName;
}

public String getPanNo() 
{
	return pan_No;
}

public String getEmail() 
{
	return email;
}

public void setEmail(String email) 
{
	this.email = email;
}

public String getMobile() 
{
	return mobile;
}

public void setMobile(String mobile) 
{
	this.mobile = mobile;
}

public void setPanNo(String panNo) 
{
	this.pan_No = panNo;
}

public String getAadharNo() 
{
	return aadhar_No;
}

public void setAadharNo(String aadharNo) 
{
	this.aadhar_No = aadharNo;
}

public String getGstinNo() 
{
	return gstin_No;
}

public void setGstinNo(String gstinNo) 
{
	this.gstin_No = gstinNo;
}

public String getSupplierCompanyName() 
{
	return supplier_Company_Name;
}

public void setSupplierCompanyName(String supplierCompanyName) 
{
	this.supplier_Company_Name = supplierCompanyName;
}

public int getQuantity() 
{
	return quantity;
}

public void setQuantity(int quantity) 
{
	this.quantity = quantity;
}

}
