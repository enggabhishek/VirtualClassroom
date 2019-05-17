package com.abhi.project.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.abhi.project.dto.*;
@Repository
public class LoginTDao {
	private static final Logger logger = LoggerFactory.getLogger(LoginTDao.class);
	
    private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	public RegistrationTDto validateTLogin(String email,String pwd)
	{
		Session session = this.sessionFactory.getCurrentSession();
		
		final String querys1 ="From Teacher where email= :e1 and pwd= :p1";
		RegistrationTDto trdto = new RegistrationTDto ();
		
		try {
		
			Query query = session.createQuery(querys1);
			query.setParameter("e1",email);
			query.setParameter("p1",pwd);
			List <Teacher> l = query.list();
			Iterator<Teacher> it = l.iterator();
			if(it.hasNext())
			{
				
				Teacher t = it.next();
				trdto.setFname(t.getFname());
				trdto.setLname(t.getLname());
				trdto.setGender(t.getGender());
				trdto.setCno(t.getCno());
				trdto.setStream(t.getStream());
				trdto.setSubject(t.getSubject());
				trdto.setRatings(t.getRatings());
				trdto.setTImage(t.getTImage());
			}
			else
			{
				trdto=null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("validateTlogin run successfully");
		return trdto;
	}
	public String getTSaveImage(String email,String pwd,String subject)
	{
		Session session = this.sessionFactory.getCurrentSession();
		final String querys = "From Teacher where email= :e1 and pwd= :p1";
		String image=null;  
		try {
			
			Query query = session.createQuery(querys);
			query.setParameter("e1",email);
			query.setParameter("p1",pwd);
			List<Teacher> l = query.list();
			Iterator<Teacher> it = l.iterator();
			
			if(it.hasNext())
			{
				Teacher t = it.next();
				image= t.getTImage();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("getTSaveImage run successfully");
		return image;
		
	}
	public String getTSaveFile(String email,String pwd,String subject)
	{
		Session session = this.sessionFactory.getCurrentSession();
		final String querys = "From  Teacher where email= :e1 and pwd= :p1";
		String file=null;  
		try {
			
			Query query = session.createQuery(querys);
			query.setParameter("e1",email);
			query.setParameter("p1",pwd);
			List<Teacher> l = query.list();
			Iterator<Teacher> it = l.iterator();
			
			
			if(it.hasNext())
			{
				Teacher t=it.next();
				file= t.getFile();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("getTSaveFile run successfully");
		return file;
		
	}
	public RequestDto [] getFrequests(String email,RequestDto [] rqdto)
	{
		Session session = this.sessionFactory.getCurrentSession();
		
		String querys = "Select s.fname,s.lname,s.email,f.combine from Request f, Student  s where s.rollno = f.rollno and f.email = :e1 and f.status is null";
		int i=0;
	   
		try {
			
			SQLQuery query = session.createSQLQuery(querys);
			query.setParameter("e1",email);
			List l = query.list();
			Iterator it = l.iterator();
			while(it.hasNext())
			{
				Object o[] = (Object[])it.next();
				rqdto[i] = new RequestDto();
				System.out.println((String)o[0]);
				rqdto[i].setName((String)o[0]+ " "+(String)o[1]);
				rqdto[i].setEmail((String)o[2]);
				rqdto[i].setCombine((String)o[3]);
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("getFrequests run successfully");
		return rqdto;
		
	}
	public int  checkRequests(String email)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String querys = "from Request  where email = :e1 and status is null";
		int i=0; 
		try {
			
			Query query = session.createQuery(querys);
			query.setParameter("e1",email);
			List<Request> l = query.list();
			Iterator<Request> it = l.iterator();
			if(it.hasNext())
			{
				
				i++;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("checkRequests run successfully");
		return i;
		
	}
	public boolean saveStatus(String combine, String status)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String querys = "update Request set status = :s1" + " where combine = :c1";
		boolean res =false;   
		try {
			Query query = session.createQuery(querys);
			query.setParameter("s1",status);
			query.setParameter("c1",combine);
			int a = query.executeUpdate();
			if(a!=0)
			res=true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("saveStatus run successfully");
		return res;
		
	}
	
}