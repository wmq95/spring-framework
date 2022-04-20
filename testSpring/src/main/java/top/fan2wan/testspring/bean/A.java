package top.fan2wan.testspring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: fanT
 * @Date: 2021/11/16 9:38
 * @Description:
 */
@Component
public class A {

//	@Autowired
//	B b;

	public void say() {
		System.out.println("a say hello.....");
	}
}
