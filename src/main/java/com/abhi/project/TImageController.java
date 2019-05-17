package com.abhi.project;
import java.io.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.abhi.project.FileValidator;
import com.abhi.project.dto.RegistrationTDto;
import com.abhi.project.service.LoginService;


@Controller
@Scope("session")
public class TImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
private LoginService loginService;
@Autowired
FileValidator fileValidator;
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	


	@RequestMapping("/tic")
public ModelAndView  fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,BindingResult result,HttpServletRequest req) {
		HttpSession session =req.getSession();
		String email=(String)session.getAttribute("email");
	    String pwd=(String)session.getAttribute("tpwd");
	    String subject = (String)session.getAttribute("subject");
	    
		String msg=null;
		RegistrationTDto trdto=new RegistrationTDto();
		String image;
		InputStream inputStream = null;
		OutputStream outputStream = null;
		MultipartFile file = uploadedFile.getFile();
		fileValidator.validate(uploadedFile, result);
		String fileName = file.getOriginalFilename();

		if (result.hasErrors()) {
			return new ModelAndView("tlogin");
		}

		try {
			inputStream = file.getInputStream();

			File newFile = new File("E:/ProgrammingCodes/SpringInSTS/VCM/src/main/webapp/resources/" + fileName);
			if (!newFile.exists()) {
				newFile.createNewFile();
			}
			outputStream = new FileOutputStream(newFile);
			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  trdto.setPwd(pwd);
  	  trdto.setEmail(email);
  	  trdto.setSubject(subject);
  	  trdto.setTImage(fileName);
  	  boolean res = loginService.getTImageRegistered(trdto);
  	  
  	  if(res==true)
  	  {
  		  image =loginService.getTSImage(email,pwd,subject);
		  msg="Image Uploaded Successfully";
		  session.setAttribute("pic1", image);
          new ModelAndView("tlogin", "imsg",msg);
  	  }
		return new ModelAndView("tlogin", "message", fileName);

	}
}