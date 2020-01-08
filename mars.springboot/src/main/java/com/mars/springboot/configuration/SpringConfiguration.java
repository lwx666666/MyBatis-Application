package com.mars.springboot.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.jolbox.bonecp.BoneCPDataSource;
import com.mars.springboot.dao.UserDao;

/**
 * 此类为Spring的配置类
 * 相当于Spring的配置文件
 * @author libo
 *
 */
@Configuration
@ComponentScan(basePackages= {"com.mars.springboot"}) // 开启注解扫描
@PropertySource(value= {"classpath:jdbc.properties"},ignoreResourceNotFound=true) // 引入资源文件
public class SpringConfiguration {
	
	/**
	 * 通过Bean注解，将对象交给Spring管理
	 * 相当于配置中的Bean标签
	 * @return
	 */
	@Bean
	public UserDao getUserDao() {
		return new UserDao();
	}
	// 获取资源文件中的属性值
	@Value("${driverClassName}")
	private String driverClassName;
	@Value("${jdbcUrl}")
	private String jdbcUrl;
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;
	@Bean(destroyMethod="close")
	public DataSource dataSource() {
		BoneCPDataSource boneCpDataSource = new BoneCPDataSource();
		boneCpDataSource.setDriverClass(driverClassName);
		boneCpDataSource.setJdbcUrl(jdbcUrl);
		boneCpDataSource.setUser(username);
		boneCpDataSource.setPassword(password);
		boneCpDataSource.setIdleConnectionTestPeriodInMinutes(60);
		boneCpDataSource.setIdleMaxAgeInMinutes(30);
		boneCpDataSource.setMaxConnectionsPerPartition(100);
		boneCpDataSource.setMinConnectionsPerPartition(5);
		return boneCpDataSource;
	}
}
