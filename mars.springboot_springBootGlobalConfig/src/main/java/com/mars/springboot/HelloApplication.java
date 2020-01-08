package com.mars.springboot;

import java.util.Date;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// 在核心注解中可以排除不想让spring-boot自动完成的配置
@SpringBootApplication(exclude= {RedisAutoConfiguration.class}) // 核心注解，使用Spring-boot中的默认配置
@SpringBootConfiguration
public class HelloApplication {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "<h1>发发发</h1>";
		
	}
	@RequestMapping("/user")
	@ResponseBody
	public User user() {
		User u = new User();
		u.setUid(2);
		u.setUsername("张三");
		u.setBirthday(new Date());
		return u;
	}
	
	public static void main(String[] args) {
		// Springboot的入口，运行的应用必须包含SpringBootApplication
		//SpringApplication.run(HelloApplication.class, args);
		SpringApplication app = new SpringApplication(HelloApplication.class);
		// 取消Springboot的banner
		//app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
