package top.fan2wan.testspring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: fanT
 * @Date: 2021/11/17 9:43
 * @Description:
 */
@Aspect
@Component
public class AspectJ {

	public AspectJ() {
		System.out.println("create AspectJ..............");
	}

	@Pointcut("execution(public * *(..))")
	private void publicMethod() {}


	@Before("publicMethod()")
	public void before() {
		System.out.println("...........before..........");
	}
}
