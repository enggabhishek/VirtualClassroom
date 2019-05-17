package com.abhi.project;
import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.abhi.project.service.LoginService;
import com.abhi.project.dto.*;

@Controller
@Scope("session")
public class ListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginService loginService;
	
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

@RequestMapping("/lic")
public ModelAndView  doPost(HttpServletRequest req) {
 HttpSession session = req.getSession();
 String email = (String)session.getAttribute("email");
 System.out.println("This is the first "+email);
 int i = loginService.checkFrequests(email);
 System.out.println("The value of i is "+ i);
 if(i!=0)
 {
	 RequestDto[] rqdto = new RequestDto[i];
	 RequestDto[] r = loginService.getRequests(email,rqdto);
     session.setAttribute("rqdto",r);
     ModelAndView model=new ModelAndView("request");
	 return model ;
 }
 
	 String msg = "There are no friend requests pending";
	 session.setAttribute("emsg",msg);
	 ModelAndView model=new ModelAndView("request");
	 return model ;
}
}
