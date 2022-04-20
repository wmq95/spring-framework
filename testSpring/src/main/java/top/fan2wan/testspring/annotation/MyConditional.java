package top.fan2wan.testspring.annotation;

import org.springframework.context.annotation.Conditional;
import top.fan2wan.testspring.condition.MissBeanCondition;

import java.lang.annotation.*;

/**
 * @Author: fanT
 * @Date: 2021/11/12 9:12
 * @Description:
 *
 * Conditional 注解 需要一个实现condition#match方法得实现类
 *可以通过asm读取类所有注解信息 然后通过反射创建类去调用match方法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Conditional(MissBeanCondition.class)
public @interface MyConditional {
	String name();
}
