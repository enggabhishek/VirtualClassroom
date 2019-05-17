package com.abhi.project;
import java.io.*;  
import javax.servlet.*;  
import javax.servlet.http.*;
import org.springframework.stereotype.Controller;
//@WebServlet("/photo")
@Controller
public class DisplayImage extends HttpServlet {  
	private static final long serialVersionUID = 1L;
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response)  
             throws IOException  
    {  
    response.setContentType("image/jpeg");  
    ServletOutputStream out;  
    out = response.getOutputStream();  
    FileInputStream fin = new FileInputStream("E:/ProgrammingCodes/JEE/ITM/kkkk.JPG");  
    BufferedInputStream bin = new BufferedInputStream(fin);  
    BufferedOutputStream bout = new BufferedOutputStream(out);  
    int ch =0; ;  
    while((ch=bin.read())!=-1)  
    {  
    	 bout.write(ch);
    
    }  
      
    bin.close();  
    fin.close();  
    bout.close();  
    out.close();  
    }  
}  
