package com.abhi.project.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.abhi.project.dao.*;
import com.abhi.project.dto.*;
@Service
public class LoginService {
	
	private SaveDao saveDao;
	private SaveTDao saveTDao;
	private LoginDao loginDao;
	private LoginTDao loginTDao;
	
	public void setSaveDao(SaveDao saveDao) {
		this.saveDao = saveDao;
	}
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	public void setLoginTDao(LoginTDao loginTDao) {
		this.loginTDao = loginTDao;
	}
	
	public void setSaveTDao(SaveTDao saveTDao) {
		this.saveTDao = saveTDao;
	}
	
	@Transactional
public RegistrationDto getLogin(String rollno,String pwd)
{
	return loginDao.validateLogin(rollno,pwd);
}
	@Transactional
public boolean getRegistered(RegistrationDto rdto)
{
 
   System.out.println(rdto.getDob());
   return saveDao.save(rdto);
}
	@Transactional
public boolean savefriendstatus(String rollno,String tmail,String combine)
{
	return saveDao.saveFstatus(rollno,tmail,combine);
}
/*public String fstatus(String combine)
{
	return loginDao.getFstatus(combine);
}*/
@Transactional
public RegistrationTDto getTLogin(String rollno,String pwd)
{
	return loginTDao.validateTLogin(rollno,pwd);
}
@Transactional
public boolean getTRegistered(RegistrationTDto rtdto)
{
   
   return saveTDao.save(rtdto);
}

@Transactional
public boolean getImageRegistered(RegistrationDto rdto)
{
  
   return saveDao.saveImage(rdto);
}
@Transactional
public String getSImage(String rollno,String pwd)
{
	return loginDao.getSaveImage(rollno,pwd);
}
@Transactional
public boolean getTImageRegistered(RegistrationTDto trdto)
{
  
   return saveTDao.saveTImage(trdto);
}
@Transactional
public String getTSImage(String email,String pwd,String subject)
{
	return loginTDao.getTSaveImage(email,pwd,subject);
}
@Transactional
public RegistrationTDto[] getDetails(String stream,RegistrationTDto[] trdto)
{
	return loginDao.checkDetails(stream,trdto);
	
}
@Transactional
public int checkService(String stream)
{
	return loginDao.checkStream(stream);
}
@Transactional
public boolean getTFileRegistered(RegistrationTDto trdto)
{
   return saveTDao.saveTFile(trdto);
}
@Transactional
public String getTSFile(String email,String pwd,String subject)
{
	return loginTDao.getTSaveFile(email,pwd,subject);
}
@Transactional
public RequestDto[] getRequests(String email,RequestDto []rqdto)
{
	return loginTDao.getFrequests(email,rqdto);
}
@Transactional
public int checkFrequests(String email)
{
	return loginTDao.checkRequests(email);
}
@Transactional
public boolean sStatus(String combine,String d)
{
	
	 return loginTDao.saveStatus(combine,d);
}
@Transactional
public boolean saveRates(int ratings,String email)
{
	 return loginDao.saveRatings(ratings,email);
}
@Transactional
public double getRatings(String email)
{
	return saveTDao.getRates(email);
}
}
