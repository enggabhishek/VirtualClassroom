package com.abhi.project.dto;

public class RequestDto {
	
private String combine;	
private String name;
private String email;


public void setName(String name)
{
	this.name= name;
}
public void setEmail(String email)
{
	this.email = email;
}
public void setCombine(String combine)
{
	this.combine= combine;
}
public String getName()
{
	return this.name;
}
public String getEmail()
{
	return this.email;
}
public String getCombine()
{
	return this.combine;
}

}
