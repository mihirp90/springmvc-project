package org.mihir.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
	
	
	@RequestMapping(value="/admissionForm.html", method=RequestMethod.GET)
	public ModelAndView getAdmissionForm() {
		ModelAndView model = new ModelAndView("AdmissionForm");
		return model;
		
	}
	
	/*
	 * For default value in @RequestParam, user @RequestParam(value="studentName", defaultValue="Mr. XYZ"
	 */
	
	/*@RequestMapping(value="/submitForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam(value="studentName", defaultValue="Mr. XYZ") String studentName, 
			@RequestParam("skill") String skill) {
		
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		String output = "Detailed Submitted By you:- \n" + "Name : " + studentName + "\n" + " skill is : " + skill; 
		model.addObject("formDetails", output);
		return model;
	}*/
	
	/*
	 * RequestParam with Map to handle large number of parameters
	 */
			
	/*@RequestMapping(value="/submitForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionFormUsingMap(@RequestParam Map<String, String> reqPar) {
		
		String studentName = reqPar.get("studentName");
		String skill = reqPar.get("skill");
	
		System.out.println(skill +"  " + studentName);
		
		Student student = new Student();
		student.setStudentName(studentName);
		student.setSkill(skill);
		
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		model.addObject("headerValue", "Welcome to Awadh College Of Engineering");
		model.addObject("studentDetails", student);
		return model;
	}*/
	
	/*
	 * Implementing above functionality using ModelAttribute
	 */
	@RequestMapping(value="/submitForm.html", method=RequestMethod.POST)
	public ModelAndView submitAdmissionFormUsingModel(@ModelAttribute("studentDetails") Student studentDetails, BindingResult result) {
		
		if(result.hasErrors()) {
			ModelAndView model = new ModelAndView("AdmissionForm");
			return model;
		}
		ModelAndView model = new ModelAndView("AdmissionSuccess");
		return model;
	}
	
	/*?
	 * Here in both method we are using one common object called as headerValeue, so instead of declaring common object 
	 * in every method, spring provide an alternative way to do the same things using ModelAttribute at method level.
	 * Spring MVC first call this method then call rest method...........
	 */

	@ModelAttribute
	public void addingCommonObject(Model model1) {
		model1.addAttribute("headerValue", "Welcome to Awadh College Of Engineering");
	}
	 
}
