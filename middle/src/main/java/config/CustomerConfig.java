package config;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dao.CustomerDaoImpl;


@Configuration
//@Import ( CustomerMapper.class)
public class CustomerConfig {
	@Autowired
	private CustomerDaoImpl customerDao;
	private SqlSessionFactory sqlSessionFactory;
	
	public CustomerConfig() {
		try {
			String resource = "dao/mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {e.printStackTrace();}
	}
	
	@Bean
	public CustomerDaoImpl customerDao() {
		CustomerDaoImpl customer = new CustomerDaoImpl();
		customer.setDataSource(sqlSessionFactory); // mybatis Àû¿ë
		return customer;
	}
	
}
