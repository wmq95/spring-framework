package top.fan2wan.testspring.config;

import org.springframework.context.annotation.ComponentScan;
import top.fan2wan.testspring.annotation.MyScan;

/**
 * @Author: fanT
 * @Date: 2021/11/10 14:31
 * @Description:
 */

@MyScan({"top.fan2wan.testspring.bean"})
@ComponentScan("top.fan2wan.testspring.postprocessor")
public class MyPackageScanConfig {
}
