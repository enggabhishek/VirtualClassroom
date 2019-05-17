package com.abhi.project;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import com.abhi.project.dto.*;
import com.abhi.project.service.*;

@Controller
@Scope("session")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;
	
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	@RequestMapping("/lc")
	public  ModelAndView doPost (HttpServletRequest req){
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String rollno = req.getParameter("rollno");
		String pwd=req.getParameter("pwd");
		String msg =null;
		String option=req.getParameter("option");
		if(option.equals("student")) 
		{
			RegistrationDto rdto =loginService.getLogin(rollno,pwd);
			
		if(rdto!=null)
		{
			String image=rdto.getImage();
			String name = rdto.getFname() +" "+ rdto.getLname();
			String address = rdto.getAddress();
			String gender = rdto.getGender();
			String email = rdto.getEmail();
			Double tper = rdto.getTper();
			Double twper = rdto.getTwper();
			String tpy = df.format(rdto.getTpy());
			String twpy = df.format(rdto.getTwpy());
			String tsname = rdto.getTsname();
			String twsname = rdto.getTwsname();
			String cno = rdto.getCno();
			String stream = rdto.getStream();
			String dob = df.format(rdto.getDob());
			HttpSession session = req.getSession(true);
              session.setAttribute("user", name);
              session.setAttribute("rollno", rollno);
              session.setAttribute("pwd", pwd);
              session.setAttribute("image",image);
              session.setAttribute("address", address);
              session.setAttribute("gender", gender);
              session.setAttribute("email", email);
              session.setAttribute("tper", tper);
              session.setAttribute("twper", twper);
              session.setAttribute("tpy", tpy);
              session.setAttribute("twpy", twpy);
              session.setAttribute("tsname", tsname);
              session.setAttribute("twsname", twsname);
              session.setAttribute("cno", cno);
              session.setAttribute("dob",dob);
              session.setAttribute("stream", stream);
              session.setMaxInactiveInterval(300);
              System.out.println(image);
              ModelAndView model=new ModelAndView("login");
			 return model ;
		}
	
			msg="Invalid Rollno or Password";
			System.out.println(msg);
			ModelAndView model1=new ModelAndView("home","hmsg",msg);
			return model1;
	
		
		}
			RegistrationTDto trdto=loginService.getTLogin(rollno,pwd);
			if(trdto!=null)
			{
				double a = loginService.getRatings(rollno);
				String name = trdto.getFname() + " "+trdto.getLname();
				HttpSession session = req.getSession(true); 
	              session.setAttribute("user", name);
	              session.setAttribute("subject",trdto.getSubject());
	              session.setAttribute("cno", trdto.getCno());
	              session.setAttribute("gender",trdto.getGender());
	              session.setAttribute("stream", trdto.getStream());
	              session.setAttribute("email", rollno);
	              session.setAttribute("pwd", pwd);
	              session.setAttribute("image",trdto.getTImage());
	              session.setAttribute("rates",a);
	              session.setMaxInactiveInterval(300);
	              ModelAndView model=new ModelAndView("tlogin");
	 			 return model;
				   
			}
			
			
				msg="Invalid Rollno or Password";
				req.getSession().setAttribute("msg", msg);
				 ModelAndView model1=new ModelAndView("home");
				 return model1;
				
				
			
		}
		
		
				
	}


