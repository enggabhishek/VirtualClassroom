package com.abhi.project;

import com.abhi.project.service.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//@WebServlet("/rateserv")
@Controller
public class RateController extends HttpServlet{
	private static final long serialVersionUID = 1L;
private LoginService loginService;
	
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@RequestMapping("/rc")
	public  ModelAndView doPost(HttpServletRequest req) {
		HttpSession session = req.getSession();
		String email = req.getParameter("tmail");
		System.out.println(email);
		String rollno =(String)session.getAttribute("rollno");
		System.out.println(rollno);
		String msg1=null;
		int ratings = Integer.parseInt(req.getParameter("numbers"));
		System.out.println("this is "+ ratings);
		boolean res1 = loginService.saveRates(ratings,email);
		 if(res1==true)
		{
			msg1 ="You have successfully rated your teacher";
			session.setAttribute("msg", msg1);
			 ModelAndView model=new ModelAndView("rate");
			 return model ;
		}
		 ModelAndView model=new ModelAndView("rate");
		 return model ;
	}
	
}
