package vn.topica.itlab4.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Product {
	private int id;
	private String name;
	private String imgUrl;
	private int price;
	private int sale;
	private int reserve;
	private Date dateInput;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSale() {
		return sale;
	}
	public void setSale(int sale) {
		this.sale = sale;
	}
	public int getReserve() {
		return reserve;
	}
	public void setReserve(int reserve) {
		this.reserve = reserve;
	}
	public Date getDateInput() {
		return dateInput;
	}
	public void setDateInput(Date dateInput) {
		this.dateInput = dateInput;
	}
	public void setDateInput(String date) {
		String pattern = "dd/mm/yyyy";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			this.dateInput = df.parse(date);
		} catch (ParseException e) {
			this.dateInput=new Date();
		}
	}
	public Product(int id, String name, String imgUrl, int price, int sale, int reserve, String date) {
		super();
		this.id = id;
		this.name = name;
		this.imgUrl = imgUrl;
		this.price = price;
		this.sale = sale;
		this.reserve = reserve;
		String pattern = "dd/mm/yyyy";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			this.dateInput = df.parse(date);
		} catch (ParseException e) {
			this.dateInput=new Date();
		}
	}
	
}
