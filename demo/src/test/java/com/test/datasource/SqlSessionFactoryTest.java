package com.test.datasource;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.cms.dto.ProductVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:context/root-context.xml")
public class SqlSessionFactoryTest {
	
	@Autowired
	private SqlSessionFactory factory;
	
	@Test
	public void test() {
		SqlSession session=factory.openSession();		
		
		List<ProductVO> productList=
				session.selectList("ProductMapper.selectProductList");
		for(ProductVO product:productList){
			System.out.println(product);
		}
	}

}






