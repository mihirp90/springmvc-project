package org.mihir.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/greet")  // it makes the /welcome as relative path and if we try https://..../welcome then it will not work.
public class HelloControllerUsingAnnotation {

	@RequestMapping ("/welcome")
	public ModelAndView helloWorld() {
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("msg", "hello world");
		return model;
	}
	
	@RequestMapping ("/welcomeback")
	public ModelAndView welcomeBack() {
		ModelAndView model = new ModelAndView("HelloPage");
		model.addObject("welcomemsg", "welcome back to hello world");
		return model;
	}
	
	/*
	 * In this case if we type https://..../greet/welcome/india/mihir then it will call this method otherwise it will not call this method.
	 * Here we will take user as well as country by using PathVariable annotation
	 */
	
	//@RequestMapping ("/welcome/{countryName}/{userName}")
	/*public ModelAndView welcomeWithCountyNUser(@PathVariable("userName") String user, @PathVariable("countryName") String country) {
		ModelAndView model = new ModelAndView("HelloPage");
		String output = "Hello I am " + user + " and i am from " + country;
		model.addObject("userwelcome", output);
		return model;
	}*/
	
	/*
	 * If you want to use PathVariable with Map as show in below then we must have to add <mvc:annotation-driven/> in xml.
	 */
	@RequestMapping ("/welcome/{countryName}/{userName}")
	public ModelAndView pathVariableUsingMap(@PathVariable Map<String, String> pathVars) {
		
		ModelAndView model = new ModelAndView("HelloPage");
		String user = pathVars.get("userName");
		String country = pathVars.get("countryName");
		String output = "Hello I am " + user + " and i am belongs to " + country;
		model.addObject("userwelcome", output);
		return model;
	}
}
