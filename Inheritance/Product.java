import java.util.Calendar;

public class Product {
	private String productName;
	private java.util.Calendar saleDate;
	private double price;
	// constructor of Product class
	public Product(String sName, Calendar sDate, double price) {
		productName = sName;
		saleDate = sDate;
		this.price = price;
	}
	// GETTER AND SETTER METHODS
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	// GETTER AND SETTER METHODS
	public java.util.Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(java.util.Calendar saleDate) {
		this.saleDate = saleDate;
	}
	// GETTER AND SETTER METHODS
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	//toString method
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", saleDate=" + Test.makeStringDate(saleDate) + ", price=" + price + "]";
	}

	

}
