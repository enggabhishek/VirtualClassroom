package com.abhi.project.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="TEACHER")
public class Teacher {
	@Id
	@Column(name="email")
	private	String email;
	@Column(name="fname", length= 20, nullable=false)
	private	String fname;
	@Column(name="lname", length= 20)
	private	String lname;
	@Column(name="pwd", length= 20, nullable=false)
	private	String pwd;
	@Column(name="cno", length= 20)
	private	String cno;
	@Column(name="address", length= 250)
	private String address;
	@Column(name="dob", nullable=false)
	private Date dob;
	@Column(name="stream", length= 40, nullable=false)
	private String stream;
	@Column(name="gender", length= 10, nullable=false)
	private String gender;
	@Column(name="subject", length= 40, nullable=false)
	private String subject;
	@Column(name="image", length= 100)
	private String image;
	@Column(name="file", length= 100)
	private String file;
	@Column(name="status")
	private String status;
	@Column(name="ratings")
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
	public String getFname()
	{
		return this.fname;
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
