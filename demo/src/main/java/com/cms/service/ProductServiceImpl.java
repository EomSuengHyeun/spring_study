package com.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.cms.dao.ProductDAO;
import com.cms.dao.ProductDAOImpl;
import com.cms.dto.ProductVO;
import com.cms.dto.SearchCriteria;

public class ProductServiceImpl implements ProductService {
	
	private static ProductServiceImpl instance=new ProductServiceImpl();
	private ProductServiceImpl(){}
	public static ProductServiceImpl getInstance(){
		return instance;
	}
	
	private ProductDAO productDAO=ProductDAOImpl.getInstance();
	
	@Override
	public List<ProductVO> getProductList() throws SQLException {
		List<ProductVO> productList=productDAO.selectProductList();
		return productList;
	}

	@Override
	public ProductVO getProductByID(int product_id) throws SQLException {
		ProductVO product=productDAO.selectProductByID(product_id);
		return product;
	}

	@Override
	public void addProduct(ProductVO product) throws SQLException {
		productDAO.insertProduct(product);

	}

	@Override
	public void modifyProduct(ProductVO product) throws SQLException {
		productDAO.updateProduct(product);
	}

	@Override
	public void removeProduct(int product_id) throws SQLException {
		productDAO.deleteProduct(product_id);

	}
	@Override
	public List<ProductVO> getSearchProductList(SearchCriteria scri) throws SQLException {
		List<ProductVO> productList=
		productDAO.selectSearchProductList(scri);
		return productList;
	}
	@Override
	public int getSearchProductListCount(SearchCriteria scri) throws SQLException {
		int count=productDAO.selectSearchProductListCount(scri);
		return count;
	}

}
