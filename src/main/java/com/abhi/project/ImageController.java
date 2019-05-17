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
import com.abhi.project.UploadedFile;
import com.abhi.project.dto.RegistrationDto;
import com.abhi.project.service.LoginService;
import com.abhi.project.FileValidator;

@Controller
@Scope("session")
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginService loginService;	
	
	@Autowired
	FileValidator fileValidator;
	
	@Autowired(required=true)
	@Qualifier(value="loginService")
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@RequestMapping("/imgc")
public  ModelAndView fileUploaded(@ModelAttribute("uploadedFile") UploadedFile uploadedFile,BindingResult result, HttpServletRequest req)  {
	HttpSession session =req.getSession();
	String rollno =(String)session.getAttribute("rollno");
    String pwd =(String)session.getAttribute("pwd");
    String image=null;
    String msg=null;
	RegistrationDto rdto = new RegistrationDto();
	
	InputStream inputStream = null;
	OutputStream outputStream = null;
	MultipartFile file = uploadedFile.getFile();
	fileValidator.validate(uploadedFile, result);
	String fileName = file.getOriginalFilename();

	if (result.hasErrors()) {
		return new ModelAndView("login");
	}
	
	
	try {
		inputStream = file.getInputStream();

		File newFile = new File("E:/ProgrammingCodes/SpringInSTS/VCM/src/main/webapp/resources/"+ fileName);
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
	
	rdto.setRollno(rollno);
    rdto.setPwd(pwd);
    rdto.setImage(fileName); 
	boolean res =loginService.getImageRegistered(rdto);
	
	
	if(res==true)
	{
		
		image=loginService.getSImage(rollno, pwd);
        msg="Image Uploaded Successfully";
        session.setAttribute("pic1", image);
        return new ModelAndView("login","imsg", msg);
	}

	
	return new ModelAndView("login", "message", fileName);

}
}