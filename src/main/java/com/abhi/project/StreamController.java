package com.abhi.project;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.project.dto.RegistrationTDto;
import com.abhi.project.service.*;
//@WebServlet("/stream")
@Controller
@Scope("session")
public class StreamController extends HttpServlet {	
	private static final long serialVersionUID = 1L;
private LoginService loginService;
	
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	

@RequestMapping("/sc")
public ModelAndView doPost(HttpServletRequest req){
	String stream=req.getParameter("st");
	int i=loginService.checkService(stream);
	HttpSession session = req.getSession();
	String rollno = (String) session.getAttribute("rollno");
	String msg = null;
	if(i!=1)
	{ 
	RegistrationTDto trdto[] = new RegistrationTDto[i-1];
	RegistrationTDto []trdto1 =loginService.getDetails(stream,trdto);
	session.setAttribute("rollno", rollno);
	session.setAttribute("trdto", trdto1);	
	return new ModelAndView("subject") ;
	}
		msg="No teacher found in this stream";
		session.setAttribute("teach", msg);
		return new ModelAndView("login") ;
	
}
}
