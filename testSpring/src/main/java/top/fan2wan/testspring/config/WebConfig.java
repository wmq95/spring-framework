package top.fan2wan.testspring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @Author: fanT
 * @Date: 2022/4/18 9:11
 * @Description: WebConfig
 */
@ComponentScan({"top.fan2wan.testspring.bean"})
@Configuration
@EnableWebMvc
public class WebConfig {

}
