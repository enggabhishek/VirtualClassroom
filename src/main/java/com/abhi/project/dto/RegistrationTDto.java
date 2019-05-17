package com.abhi.project.dto;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class RegistrationTDto{
	
	
	private	String email;
	private	String fname;
	private	String lname;
	private	String pwd;
	private	String cno;
	private String address;
	private Date dob;
	private String stream;
	private String gender;
	private String subject;
	private String image;
	private String file;
	private String status;
	private double ratings;
	public void setRatings(double r)
	 {
		 this.ratings=r;
	 }
	public void setStatus(String status)
		 {
			 this.status=status;
		 }
	public void setFile(String file)
	{
		this.file=file;
	}
	public void setFname(String fname)
	{
		this.fname=fname;
	}
	public void setLname(String lname)
	{
		this.lname=lname;
	}
	public void setEmail(String email)
	{
		this.email=email;
	}
	public void setPwd(String pwd)
	{
		this.pwd=pwd;
	}
	public void setCno(String cno)
	{
		this.cno=cno;
	}
	public void setAddress(String address)
	{
		this.address=address;
	}
	public void setStream(String stream)
	{
		this.stream=stream;
	}
	public void setGender(String gender)
	{
		this.gender=gender;
	}
	public void setSubject(String subject)
	{
		this.subject=subject;
	}
	public void setDob(String d)
	{
		Date dob1=null;
	 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	 try {
		dob1=sdf.parse(d);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	 this.dob=dob1;
	}
	public void setTImage(String image)
	{
		this.image=image;
	}
	public String getFname() {
		return fname;
	}
	public String getLname()
	{
		return this.lname;
	}
	public String getEmail()
	{
		return this.email;
	}
	public String getPwd()
	{
		return this.pwd;
	}
	public String getCno()
	{
		return this.cno;
	}
	public String getStream()
	{
		return this.stream;
	}
	public String getSubject()
	{
		return this.subject;
	}
	public String getAddress()
	{
		return this.address;
	}
	public Date getDob()
	{
		return this.dob;
	}
	public String getGender()
	{
		return this.gender;
	}
	public String getTImage()
	{
		return this.image;
	}
	public String getFile()
	{
		return this.file;
	}
	public String getStatus()
	{
		return this.status;
	}
	public double getRatings()
	{
		return this.ratings;
	}
	
}
