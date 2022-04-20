package top.fan2wan.testspring;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.util.ClassUtils;
import top.fan2wan.testspring.annotation.MyConditional;
import top.fan2wan.testspring.bean.A;
import top.fan2wan.testspring.bean.User;
import top.fan2wan.testspring.config.AopConfig;
import top.fan2wan.testspring.config.AppConfig;
import top.fan2wan.testspring.config.MyPackageScanConfig;
import top.fan2wan.testspring.config.UserConfig;

import java.io.IOException;
import java.util.Map;

/**
 * @Author: fanT
 * @Date: 2021/11/4 11:07
 * @Description:
 *
 * 所有得基于注解开发 都依赖于Spring得ConfigurationClassPostProcessor 后置处理器
 */
public class TestBean {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(UserConfig.class);
		User user = context.getBean(User.class);
		System.out.println(user.getName());

		/*DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(User.class);
		factory.registerBeanDefinition("user", beanDefinition);
		System.out.println("register beanDefinition success....");
		User bean = factory.getBean(User.class);
		System.out.println(bean);*/

		/*ApplicationContext context = new AnnotationConfigApplicationContext(MyPackageScanConfig.class);
		User user = context.getBean(User.class);
		System.out.println(user);*/

		//A a = context.getBean(A.class);
		//a.say();
	}
}
