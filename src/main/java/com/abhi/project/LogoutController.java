package com.abhi.project;

import javax.servlet.http.*;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@WebServlet("/loutCon")
@Controller
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@RequestMapping("/lgc")
	public String doPost(HttpServletRequest req)  { 
		HttpSession session = req.getSession();  
		session.getMaxInactiveInterval();
		session.invalidate();
		req.setAttribute("msg", "You successfully logged out goto homepage for login ");
		//req.getRequestDispatcher("lgout.jsp").forward(req,resp);
		return "lgout";
	}

}
