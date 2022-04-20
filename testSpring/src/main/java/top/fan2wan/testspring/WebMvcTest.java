package top.fan2wan.testspring;

import org.apache.catalina.Context;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import top.fan2wan.testspring.config.WebConfig;

import javax.servlet.ServletContext;

/**
 * @Author: fanT
 * @Date: 2022/4/18 10:21
 * @Description:
 */
public class WebMvcTest {
	public WebMvcTest() {
		Tomcat tomcat = new Tomcat();//创建tomcat对象
		tomcat.setPort(8088); //设置端口
		tomcat.getConnector();

		//创建web容器上下文
		Context context = tomcat.addContext("", "f://tempdir");
		try {
			//注册前端控制器
			DispatcherServlet dispatcherServlet = new DispatcherServlet(
					this.createApplicationContext(context.getServletContext()));
			Wrapper servlet = tomcat.addServlet(context, "dispatcherServlet", dispatcherServlet);
			servlet.setLoadOnStartup(1);
			servlet.addMapping("/*");

			tomcat.start();
			tomcat.getServer().await();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建spring容器的应用上下文对象
	 *
	 * @param servletContext WEB容器上下文对象
	 * @return spring容器应用上下文对象
	 */
	public WebApplicationContext createApplicationContext(
			ServletContext servletContext) {
		AnnotationConfigWebApplicationContext ctx
				= new AnnotationConfigWebApplicationContext();
		ctx.register(WebConfig.class);
		ctx.setServletContext(servletContext);
		ctx.refresh();
		ctx.registerShutdownHook();
		RequestMappingHandlerMapping bean = ctx.getBean(RequestMappingHandlerMapping.class);
		System.out.println(bean);
		return ctx;
	}

	public static void main(String[] args) {
		new WebMvcTest();
	}
}
