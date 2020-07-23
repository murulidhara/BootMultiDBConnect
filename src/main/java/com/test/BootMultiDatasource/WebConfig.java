package com.test.BootMultiDatasource;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class WebConfig {
	
// First Database instance for IBM DBVisualizer
//	@Bean(name = "db1")
//	@ConfigurationProperties(prefix = "spring.datasource")
//	@Primary
//	public DataSource dataSource1() {
//		return DataSourceBuilder.create().build();
//	}
	
	//First Database instance for H2 In-Memory
	@Bean(name = "db1")
	@ConfigurationProperties(prefix = "spring.datasource")
	@Primary
	public EmbeddedDatabase dataSource1() {
	    return new EmbeddedDatabaseBuilder().
	            setType(EmbeddedDatabaseType.H2).
	            setName("DB1").
	            addScript("schema1.sql").
	            addScript("data1.sql").
	            build();

	}

	@Bean(name = "jdbcTemplate1")
	public NamedParameterJdbcTemplate jdbcTemplate1(@Qualifier("db1") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}

// Second Database instance for IBM DBVisualizer
//	@Bean(name = "db2")
//	@ConfigurationProperties(prefix = "spring.second-db")
//	public DataSource dataSource2() {
//		return  DataSourceBuilder.create().build();
//	}
	
//Second Database instance for H2 In-Memory
	@Bean(name = "db2")
	@ConfigurationProperties(prefix = "spring.second-db")
	public EmbeddedDatabase dataSource2() {
	    return new EmbeddedDatabaseBuilder().
	            setType(EmbeddedDatabaseType.H2).
	            setName("DB2").
	            addScript("schema2.sql").
	            addScript("data2.sql").
	            build();

	}

	@Bean(name = "jdbcTemplate2")
	public NamedParameterJdbcTemplate jdbcTemplate2(@Qualifier("db2") DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}

}
