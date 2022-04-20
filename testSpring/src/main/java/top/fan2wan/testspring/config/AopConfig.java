package top.fan2wan.testspring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import top.fan2wan.testspring.bean.User;

/**
 * @Author: fanT
 * @Date: 2021/11/17 9:35
 * @Description:
 */
@Configuration
@EnableAspectJAutoProxy
@ComponentScan({"top.fan2wan.testspring.bean", "top.fan2wan.testspring.aop"})
public class AopConfig {

	@Bean
	public User user() {
		return new User("ft");
	}
}
