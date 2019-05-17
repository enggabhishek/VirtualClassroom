package com.abhi.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@RequestMapping(value="/home",method = RequestMethod.GET)
	public String home()
	{
		return "home";
	}
	@RequestMapping(value="/regserv",method=RequestMethod.GET)
	public ModelAndView studentRegister(){
		ModelAndView model=new ModelAndView("register");		//jsp name
		return model;
		
	}	
	@RequestMapping(value="/tregserv",method=RequestMethod.GET)
	public ModelAndView teacherRegister(){
		ModelAndView model=new ModelAndView("tregister");		//jsp name
		return model;
		
	}	
	@RequestMapping(value="/success",method=RequestMethod.GET)
	public ModelAndView Success(){
		ModelAndView model=new ModelAndView("success");		//jsp name
		return model;
		
	}
	
	@RequestMapping(value="/lgout",method=RequestMethod.POST)
	public ModelAndView Logout(){
		ModelAndView model=new ModelAndView("lgout");		//jsp name
		return model;
		
	}
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public ModelAndView Login(){
		ModelAndView model=new ModelAndView("login");		//jsp name
		return model;
		
	}
	@RequestMapping(value="/tlogin",method=RequestMethod.GET)
	public ModelAndView TeacherLogin(){
		ModelAndView model=new ModelAndView("tlogin");		//jsp name
		return model;
		
	}
	@RequestMapping(value="/subject",method=RequestMethod.GET)
	public ModelAndView Subject(){
		ModelAndView model=new ModelAndView("subject");		//jsp name
		return model;
		
	}
	@RequestMapping(value="/request",method=RequestMethod.GET)
	public ModelAndView Request(){
		ModelAndView model=new ModelAndView("request");		//jsp name
		return model;
		
	}
	@RequestMapping(value="/rate",method=RequestMethod.GET)
	public ModelAndView Rate(){
		ModelAndView model=new ModelAndView("rate");		//jsp name
		return model;
		
	}
	
	
}
