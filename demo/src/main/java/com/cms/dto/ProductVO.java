package com.cms.dto;

import java.util.Date;

public class ProductVO {
	private int product_id;
	private String product_name;
	private String product_detail;
	private int product_price;
	private Date product_regDate;
	private Date product_updatedate;
	private String product_img;
	
	public ProductVO(){}
	
	public ProductVO(int product_id, String product_name, String product_detail, int product_price,
			Date product_regDate, Date product_updatedate, String product_img) {
		super();
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_detail = product_detail;
		this.product_price = product_price;
		this.product_regDate = product_regDate;
		this.product_updatedate = product_updatedate;
		this.product_img = product_img;
	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getProduct_detail() {
		return product_detail;
	}

	public void setProduct_detail(String product_detail) {
		this.product_detail = product_detail;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public Date getProduct_regDate() {
		return product_regDate;
	}

	public void setProduct_regDate(Date product_regDate) {
		this.product_regDate = product_regDate;
	}

	public Date getProduct_updatedate() {
		return product_updatedate;
	}

	public void setProduct_updatedate(Date product_updatedate) {
		this.product_updatedate = product_updatedate;
	}

	public String getProduct_img() {
		return product_img;
	}

	public void setProduct_img(String product_img) {
		this.product_img = product_img;
	}

	@Override
	public String toString() {
		return "ProductVO [product_id=" + product_id + ", product_name=" + product_name + ", product_detail="
				+ product_detail + ", product_price=" + product_price + ", product_regDate=" + product_regDate
				+ ", product_updatedate=" + product_updatedate + ", product_img=" + product_img + "]";
	}
	
	
	
	
	
	
	
}









