package top.fan2wan.testspring.postprocessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.AnnotationBeanNameGenerator;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.classreading.CachingMetadataReaderFactory;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.stereotype.Component;
import top.fan2wan.testspring.annotation.MyComponent;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: fanT
 * @Date: 2021/11/10 9:34
 * @Description: 自己实现包扫描 加载类
 */
@Component
public class MyBeanFactoryPosterProcessor implements BeanDefinitionRegistryPostProcessor {

	private ConfigurableListableBeanFactory factory;
	private MetadataReaderFactory metadataReaderFactory = new CachingMetadataReaderFactory();
	private AnnotationBeanNameGenerator generator = new AnnotationBeanNameGenerator();

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		this.factory = beanFactory;
	}


	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		// 获取包扫描路径 也许会有多个定义
		String[] locations = findLocation();

		for (String location : locations) {
			registerBeanDefinition(location, registry);
		}
	}

	private void registerBeanDefinition(String location, BeanDefinitionRegistry registry) {
		// 获取组件类
		String[] componentClass = findClass(location);

		for (String classPath : componentClass) {
			// 注册Bean
			doRegisterBeanDefinition(classPath, registry);
		}
	}

	private void doRegisterBeanDefinition(String classPath, BeanDefinitionRegistry registry) {
		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClassName(classPath);
		registry.registerBeanDefinition(generator.generateBeanName(beanDefinition, registry), beanDefinition);
	}

	private String[] findClass(String location) {
		List<String> pathList = new ArrayList<>(20);
		ClassPathResource classPathResource = new ClassPathResource(location.replace(".", "/"));
		File file = null;
		try {
			file = classPathResource.getFile();
		} catch (IOException e) {
			e.printStackTrace();
			return pathList.toArray(new String[]{});
		}

		String classPath;
		for (String s : file.list()) {
			classPath = location + "." + s;
			classPath = classPath.replace(".class", "");
			// 判断该类是不是组件 使用asm技术 读取类注解信息
			if (isComponent(classPath)) {
				pathList.add(classPath);
			}
		}
		return pathList.toArray(new String[]{});
	}

	private boolean isComponent(String classPath) {
		try {
			MetadataReader metadataReader = metadataReaderFactory.getMetadataReader(classPath);
			AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();

			// 这儿加入 判断按需加载处理condition注解
			return annotationMetadata.hasMetaAnnotation(MyComponent.class.getName());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	private String[] findLocation() {

		return new String[]{"top.fan2wan.testspring.bean"};
	}
}
