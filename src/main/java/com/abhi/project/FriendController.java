package com.abhi.project;
import com.abhi.project.service.*;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.project.util.*;
//@WebServlet("/friendserv")
@Controller
public class FriendController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginService loginService;
	
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}


@RequestMapping("/frc")
public ModelAndView doPost(HttpServletRequest req) {
	HttpSession session = req.getSession();
	String msg = null;
	String tmail = req.getParameter("tmail");
	 String rollno = (String) session.getAttribute("rollno");
	 String c = tmail + rollno;
	 Encryption encr=new Encryption();
	 String combine =encr.getHash(c.getBytes());
	 System.out.println("This is "+ combine);
	 boolean res = loginService.savefriendstatus(rollno,tmail,combine);
	if(res==false)
	{
		    msg ="The request has already been sent to the teacher";
		    session.setAttribute("lmsg", msg);
		    session.setAttribute("combine",combine);
		    ModelAndView model=new ModelAndView("subject");
			 return model ;
	}
	else if(res==true )
	{
		msg ="The request has been sent to the teacher";
		session.setAttribute("lmsg", msg);
		 ModelAndView model=new ModelAndView("subject");
		 return model ;
	}
	 ModelAndView model=new ModelAndView("subject");
	 return model ;
}
}
