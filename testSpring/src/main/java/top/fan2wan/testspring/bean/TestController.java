package top.fan2wan.testspring.bean;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: fanT
 * @Date: 2022/4/15 9:22
 * @Description: test for controller
 */
@Controller
public class TestController {

	@ResponseBody
	@RequestMapping("/test/hello")
	public String hello() {
		return "fanT";
	}
}
