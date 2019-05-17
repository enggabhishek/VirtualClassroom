package com.abhi.project;

import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.project.dto.*;
import com.abhi.project.service.*;

@Controller
public class RegisterTController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private LoginService loginService;
	
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
@RequestMapping("/regtc")
public ModelAndView doPost(HttpServletRequest req){
	String email=req.getParameter("email");
	String pwd=req.getParameter("pwd");
	String gender =req.getParameter("gender");
	String fname=req.getParameter("fname");
	String lname = req.getParameter("lname");
	String subject=req.getParameter("subject");
	String stream = req.getParameter("stream");
	String d = req.getParameter("dob");
	String cno =req.getParameter("cno");
	String address=req.getParameter("address");
	String msg=null;
	String smsg="Registration Successfull";
	  RegistrationTDto rtdto = new RegistrationTDto();
	   rtdto.setEmail(email);
	   rtdto.setPwd(pwd);
	   rtdto.setFname(fname);
	   rtdto.setLname(lname);
	   rtdto.setGender(gender);
	   rtdto.setSubject(subject);
	   rtdto.setStream(stream);
	   rtdto.setDob(d);
	   rtdto.setCno(cno);
	   rtdto.setAddress(address);
	   boolean res = loginService.getTRegistered(rtdto);
	   if(res==false)
	   {
		   msg="Email id already exists";
		   req.setAttribute("msg", msg);
		  
		   ModelAndView model= new ModelAndView("tregister");
			return model;
		   
	   }
	 	req.setAttribute("msg", smsg);
	   ModelAndView model1 =new ModelAndView("success");
		return model1;
	  
	
}
}
