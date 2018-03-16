package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.cms.dto.ProductVO;
import com.cms.dto.SearchCriteria;

public interface ProductService {
	
	List<ProductVO> getProductList()throws SQLException;
	ProductVO getProductByID(int product_id)throws SQLException;
	
	void addProduct(ProductVO product)throws SQLException;
	void modifyProduct(ProductVO product)throws SQLException;
	void removeProduct(int product_id)throws SQLException;
	
	List<ProductVO> getSearchProductList(SearchCriteria scri)
			throws SQLException;
	int getSearchProductListCount(SearchCriteria scri)
			throws SQLException;
	
}







