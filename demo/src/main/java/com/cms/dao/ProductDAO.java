package com.cms.dao;

import java.sql.SQLException;
import java.util.List;

import com.cms.dto.ProductVO;
import com.cms.dto.SearchCriteria;

public interface ProductDAO {
	
	List<ProductVO> selectProductList()throws SQLException;
	ProductVO selectProductByID(int product_id)throws SQLException;
	
	void insertProduct(ProductVO product)throws SQLException;
	void updateProduct(ProductVO product)throws SQLException;
	void deleteProduct(int product_id)throws SQLException;
	
	List<ProductVO> selectSearchProductList(SearchCriteria scri)
		throws SQLException;
	int selectSearchProductListCount(SearchCriteria scri)
		throws SQLException;
	
}













