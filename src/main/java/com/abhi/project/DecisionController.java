package com.abhi.project;

import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.project.service.LoginService;

@Controller
@Scope("session")
public class DecisionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService ;
	
	 @Autowired(required=true)
	 @Qualifier(value="loginService")
		public void setLoginService(LoginService loginService) {
			this.loginService = loginService;
		}

@RequestMapping("/dc")
public ModelAndView  doPost(HttpServletRequest req)  {
	 String status = req.getParameter("accept");
	 String status1= req.getParameter("reject");
	 String msg=null;
	 HttpSession session = req.getSession();
	
	 if(status!=null && status1==null)
	 {
		 boolean res =loginService.sStatus(status,"accept");
		 if(res==true)		
		  msg="The request is accepted";
		 session.setAttribute("dcmsg", msg);
		 ModelAndView model=new ModelAndView("request");
		 return model ;

	 }	
	 else if(status1!=null && status==null)
	 {
		 String d=null;
		 boolean res =loginService.sStatus(status,d);
		 if(res==true)
		 msg="The request is declined";
		 session.setAttribute("dcmsg", msg);
		 ModelAndView model=new ModelAndView("request");
		 return model ;
	 }
	 ModelAndView model=new ModelAndView("request");
	 return model ;
}
}
