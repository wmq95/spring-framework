package top.fan2wan.testspring.annotation;

import java.lang.annotation.*;

/**
 * @Author: fanT
 * @Date: 2021/11/10 14:30
 * @Description:
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MyComponent {
}
