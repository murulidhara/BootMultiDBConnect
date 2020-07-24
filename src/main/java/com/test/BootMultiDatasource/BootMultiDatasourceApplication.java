package com.test.BootMultiDatasource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
(exclude = { DataSourceAutoConfiguration.class, 
		ErrorMvcAutoConfiguration.class
		//			 HibernateJpaAutoConfiguration.class,
		//			 DataSourceTransactionManagerAutoConfiguration.class 
})	
@EnableTransactionManagement
public class BootMultiDatasourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMultiDatasourceApplication.class, args);
	}

}
