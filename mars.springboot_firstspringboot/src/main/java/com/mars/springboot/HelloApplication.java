package com.mars.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
// 在核心注解中可以排除不想让spring-boot自动完成的配置
@SpringBootApplication(exclude= {RedisAutoConfiguration.class}) // 核心注解，使用Spring-boot中的默认配置
@Configuration
public class HelloApplication {
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello() {
		return "发发发";
		
	}
	
	public static void main(String[] args) {
		// Springboot的入口，运行的应用必须包含SpringBootApplication
		//SpringApplication.run(HelloApplication.class, args);
		SpringApplication app = new SpringApplication(HelloApplication.class);
		// 取消Springboot的banner
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}
}
