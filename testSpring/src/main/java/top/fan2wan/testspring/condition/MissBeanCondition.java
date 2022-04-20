package top.fan2wan.testspring.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import top.fan2wan.testspring.annotation.MyConditional;

/**
 * @Author: fanT
 * @Date: 2021/11/11 9:34
 * @Description:
 */
public class MissBeanCondition implements Condition {
	@Override
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// 获取自定义得conditional 注解得值
		System.out.println(metadata.getAllAnnotationAttributes(MyConditional.class.getName()).values());
		System.out.println("match ....return false ");
		return false;
	}
}
