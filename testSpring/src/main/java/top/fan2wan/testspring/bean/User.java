package top.fan2wan.testspring.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;
import top.fan2wan.testspring.annotation.MyComponent;
import top.fan2wan.testspring.annotation.MyConditional;
import top.fan2wan.testspring.condition.MissBeanCondition;

/**
 * @Author: fanT
 * @Date: 2021/11/4 11:08
 * @Description:
 */
@Component
//@MyComponent
//@Conditional(MissBeanCondition.class)
//@MyConditional(name = "user")
public class User {
	private String name;

	public User() {
		System.out.println("User.User");
	}

	public User(String name) {
		System.out.println("name was " + name);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
/*@Bean
	@Conditional(MissBeanCondition.class)
	public User user1() {
		System.out.println("user 1 ");
		return new User();
	}*/
}
