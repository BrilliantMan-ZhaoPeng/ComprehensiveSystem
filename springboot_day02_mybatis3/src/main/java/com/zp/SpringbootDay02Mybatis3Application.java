package com.zp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@EnableTransactionManagement
@SpringBootApplication
public class SpringbootDay02Mybatis3Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootDay02Mybatis3Application.class, args);
	}
}
