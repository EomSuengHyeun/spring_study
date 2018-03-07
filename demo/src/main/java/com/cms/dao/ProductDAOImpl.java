package com.cms.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.cms.dto.ProductVO;
import com.cms.dto.SearchCriteria;
import com.jdbc.source.DataSourceDBCPMybatis;

public class ProductDAOImpl implements ProductDAO {

	private static ProductDAOImpl instance = new ProductDAOImpl();

	private ProductDAOImpl() {
	}

	public static ProductDAOImpl getInstance() {
		return instance;
	}

	private SqlSessionFactory factory 
	= DataSourceDBCPMybatis.getInstance().getSqlSessionFactory();
	
	private SqlSession session;

	private final String NAMESPACE = "ProductMapper";

	@Override
	public List<ProductVO> selectProductList()throws SQLException {
		List<ProductVO> productList = null;
		session=factory.openSession();
		try {
			productList = session.selectList(NAMESPACE + ".selectProductList", null);
		} finally {
			session.commit();
			session.close();
		}
		return productList;
	}

	@Override
	public ProductVO selectProductByID(int product_id) throws SQLException{
		ProductVO product = null;
		session=factory.openSession();
		try {
			product = (ProductVO) session.selectOne(NAMESPACE + ".selectProductByID", product_id);
		} finally {
			session.commit();
			session.close();
		}
		return product;
	}

	@Override
	public void insertProduct(ProductVO product) throws SQLException{
		session=factory.openSession();
		try {
			session.update(NAMESPACE + ".insertProduct", product);
		} finally {
			session.commit();
			session.close();
		}
	}

	@Override
	public void updateProduct(ProductVO product)throws SQLException {
		session=factory.openSession();
		try {
			session.update(NAMESPACE + ".updateProduct", product);
		} finally {
			session.commit();
			session.close();
		}

	}

	@Override
	public void deleteProduct(int product_id)throws SQLException {
		session=factory.openSession();
		try {
			session.update(NAMESPACE + ".deleteProduct", product_id);
		} finally {
			session.commit();
			session.close();
		}

	}

	@Override
	public List<ProductVO> selectSearchProductList(SearchCriteria scri) throws SQLException {
		
		int offset=scri.getPageStartRow();
		int limit=scri.getPerPageNum();
		RowBounds bounds=new RowBounds(offset,limit);
		
		session=factory.openSession();
		List<ProductVO> productList=null;
		try {
			productList=
					session.selectList(NAMESPACE+".selectSearchProductList",
									scri,bounds);
		} finally {
			session.commit();
			session.close();
		}
		
		
		return productList;
	}

	@Override
	public int selectSearchProductListCount(SearchCriteria scri) throws SQLException {
		
		session=factory.openSession();
		int count=0;
		try {
			count=(Integer)session.selectOne(NAMESPACE+".selectSearchProductCount"
					,scri);
		} finally {
			session.commit();
			session.close();
		}	
	  
		return count;
	}

}
