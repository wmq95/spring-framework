package top.fan2wan.testspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.fan2wan.testspring.bean.User;

/**
 * @Author: fanT
 * @Date: 2021/11/9 8:54
 * @Description: config for user
 */
@Configuration
public class UserConfig {

	public UserConfig() {
		System.out.println("user import.........");
	}

	@Bean
	public User user() {
		return new User();
	}
}
