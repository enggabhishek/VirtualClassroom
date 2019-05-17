package com.abhi.project;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.project.dto.*;
import com.abhi.project.service.*;

@Controller

public class RegisterController extends HttpServlet {
	
	private LoginService loginService ;
	
	 @Autowired(required=true)
	 @Qualifier(value="loginService")
	 public void setLoginService(LoginService loginService) {
			this.loginService = loginService;
		}

	private static final long serialVersionUID = 1L;
@RequestMapping("/regc")
public ModelAndView doPost( HttpServletRequest req) {
	String rollno =req.getParameter("rollno");
	String fname=req.getParameter("fname");
	String lname = req.getParameter("lname");
	String email=req.getParameter("email");
	String pwd=req.getParameter("pwd");
	String d = req.getParameter("dob");
	String tpy=req.getParameter("tpy");
	String twpy=req.getParameter("twpy");
	String stream = req.getParameter("stream");
	String cno =req.getParameter("cno");
    String twsname=req.getParameter("twsname");
    String tsname=req.getParameter("tsname");
    String gender=req.getParameter("gender");
    Double twper=0.0;
    Double tper=0.0;
    System.out.println(d);
    try {
    	twper =Double.parseDouble(req.getParameter("twper"));
    	   tper =Double.parseDouble(req.getParameter("tper"));
    }
    catch(NullPointerException e)
    {
    	System.out.println("there is an error");
    }
   
    String address=req.getParameter("address");
    String msg=null;
	String smsg="Registration Successfull";
    RegistrationDto rdto = new RegistrationDto();
    rdto.setRollno(rollno);
    rdto.setFname(fname);
    rdto.setLname(lname);
    rdto.setEmail(email);
    rdto.setPwd(pwd);
    rdto.setDob(d);
    rdto.setTpy(tpy);
    rdto.setTwpy(twpy);
    rdto.setStream(stream);
    rdto.setCno(cno);
    rdto.setTwsname(twsname);
    rdto.setTsname(tsname);
    rdto.setTper(tper);
    rdto.setTwper(twper);
    rdto.setAddress(address);
    rdto.setGender(gender);
    boolean res = loginService.getRegistered(rdto);
    if(res==false)
    {
    	msg="Roll Number already exists";
    	req.setAttribute("msg", msg);
		
		System.out.println("hello");
		ModelAndView model=new ModelAndView("register");
		return model;
    }
    
   	req.setAttribute("msg", smsg);
   	ModelAndView model1 =new ModelAndView("success");
		return model1 ;
    		
}
}
