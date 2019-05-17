package com.abhi.project.dto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="STUDENT")
public class Student {
	@Id
	@Column(name="rollno")
private String rollno;
	@Column(name="fname", length= 20, nullable=false)
private String fname;
	@Column(name="lname", length= 20)
private String lname;
	@Column(name="email", length= 50, nullable=false)
private String email;
	@Column(name="pwd", length= 20, nullable=false)
private String pwd;
	@Column(name="cno", length= 10, nullable= true)
private String cno;
	@Column(name="address", length= 250)
private String address;
	@Column(name="tsname", length= 40, nullable=false)
private String tsname;
	@Column(name="twsname", length= 40, nullable=false)
private String twsname;
	@Column(name="dob", nullable=false)
private Date dob;
	@Column(name="twpy", nullable=false)
private Date twpy;
	@Column(name="tpy", nullable=false)
private Date tpy;
	@Column(name="stream", length= 20, nullable=false)
private String stream;
	@Column(name="tper", nullable=false)
private Double tper;
	@Column(name="twper",nullable=false)
private Double twper;
	@Column(name="gender", length= 10, nullable=false)
private String gender;
	@Column(name="image", length= 100)
private String image;

 public void setRollno(String rollno)
 {
	 this.rollno=rollno;
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
 public void setTsname(String tsname)
 {
	 this.tsname=tsname;
 }
 public void setTwsname(String twsname)
 {
	 this.twsname=twsname;
 }
 public void setStream(String stream)
 {
	 this.stream=stream;
 }
 public void setTper(Double tper)
 {
	 this.tper=tper;
 }
 public void setTwper(Double twper)
 {
	 this.twper=twper;
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
 public void setTwpy(String twpy)
 {
	 Date twpy1=null;
	 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	 try {
		twpy1=sdf.parse(twpy);
	} catch (ParseException e) {
		e.printStackTrace();
	} 
	 this.twpy=twpy1;
 }
 public void setTpy(String tpy)
 {
	 Date tpy1=null;
	 SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yyyy");
	 try {
		tpy1=sdf.parse(tpy);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	this.tpy=tpy1;
 }
 public void setGender(String g)
 {
	 this.gender=g;
 }
public void setImage(String image)
{
	this.image=image;
}
public String getRollno()
{
	return this.rollno;
}
public String getFname()
{
	return this.fname;
}
public String getLname()
{
	return this.lname;
}
public String getPwd()
{
	return this.pwd;
}
public String getEmail()
{
	return this.email;
}
public String getStream()
{
	return this.stream;
}
public String getAddress()
{
	return this.address;
}
public String getTsname()
{
	return this.tsname;
}
public String getTwsname()
{
	return this.twsname;
}
public Double getTper()
{
	return this.tper;
}
public Double getTwper()
{
	return this.twper;
}
public String getCno()
{
	return this.cno;
}
public Date getDob()
{
	return this.dob;
}
public Date getTwpy()
{
	return this.twpy;
}
public Date getTpy()
{
	return this.tpy;
}
public String getGender()
{
	return this.gender;
}
public String getImage()
{
	return this.image;
}

}
