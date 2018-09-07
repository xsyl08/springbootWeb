package com.zh.springbootWeb.Controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
/**
 * @RestController = @Controller + @ResponseBody，如果你要返回到一个jsp页面，要用@Controller，不能用@RestController
 * 因为 @RestController 会把你的返回值当作数据返回，而不是页面名字（结果就是把页面名字当字符串返回）
 * 
 * @author Administrator
 * 
 */
@Controller
public class HomeController {
	@RequestMapping(value="/home")
	public String home(){
		System.out.println("redirect to home page!");
		return "index";
	}
	
	@RequestMapping(value="/goHome")
	@ResponseBody
	public ModelAndView goHome(){
		System.out.println("go to the home page!");
		ModelAndView mode = new ModelAndView();
		mode.addObject("name", "张三");
		mode.setViewName("index");
		return mode;
	}
	
	@RequestMapping(value="/testMap")
	@ResponseBody
	public Map<String, String> testMap(){
		Map<String,String> map = new HashMap<>();
		map.put("name", "admin");
		return map;
	}

}
