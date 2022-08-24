package config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.SellerDaoImpl;

@Configuration
public class SellerConfig  {
	@Autowired
	private SellerDaoImpl SellerDao;
	private SqlSessionFactory sqlSessionFactory;
	
	public SellerConfig() {
		try {
			String resource = "dao/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {e.printStackTrace();}
	}
	
	@Bean
	public SellerDaoImpl SellerDao() {
		SellerDaoImpl seller = new SellerDaoImpl();
		seller.setDataSource(sqlSessionFactory); // mybatis Àû¿ë
		return seller;
	}

	
		
}
