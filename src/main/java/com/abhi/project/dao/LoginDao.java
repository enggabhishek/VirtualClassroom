package com.abhi.project.dao;
import java.text.SimpleDateFormat;
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
public class LoginDao {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginDao.class);
	//final String querys = "select fname,lname,email,cno,address,tsname,twsname,dob,twpy,tpy,stream,tper,twper,gender from student where rollno= :r1 and pwd=:p1";
	//PreparedStatement pstmt=null;
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	//Session session = this.sessionFactory.getCurrentSession();
	public RegistrationDto validateLogin(String rollno,String pwd)
	{
		Session session = this.sessionFactory.getCurrentSession();
		
		RegistrationDto rdto = new RegistrationDto();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Query query = session.createQuery("from Student where rollno= :r1 and pwd= :p1");
			query.setParameter("r1",rollno);
			query.setParameter("p1",pwd);
			List<Student> l = query.list();
			Iterator<Student> it = l.iterator();
			System.out.println("it is working");
			if(it.hasNext())
			{
				Student o = it.next(); 
				
				rdto.setRollno(rollno);
				
				rdto.setEmail(o.getEmail());
				System.out.println("this is " + o.getCno());
				rdto.setFname(o.getFname());  
				rdto.setLname(o.getLname());
				rdto.setCno(o.getCno());
				rdto.setAddress(o.getAddress());
				rdto.setTsname(o.getTsname());
				rdto.setTwsname(o.getTwsname());
				rdto.setDob(df.format(o.getDob()));
				rdto.setTwpy(df.format(o.getTwpy()));
				rdto.setTpy(df.format(o.getTpy()));
				rdto.setStream(o.getStream());
				rdto.setTper(o.getTper());
				rdto.setTwper(o.getTwper());
				rdto.setGender(o.getGender());
				rdto.setImage(o.getImage());
			}
			else
			{
				rdto=null;
			}
		} catch (Exception e) {
			System.out.println("The query is wrong");
		}
		logger.info("validatelogin run successfully");

		return rdto;
	}

	
	public String getSaveImage(String rollno,String pwd)
	{
		Session session = this.sessionFactory.getCurrentSession();
		final String querys= "From Student where rollno = :r1 and pwd =:p1";
		String image=null;
		try {
			Query query = session.createQuery(querys);
			query.setParameter("r1",rollno);
			query.setParameter("p1",pwd);
			List<Student> l = query.list();
			Iterator<Student> it = l.iterator();
		
			if(it.hasNext())
			{
				Student o = it.next(); 
				image= o.getImage();
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		logger.info("getSaveImage run successfully");
		return image;
		
	}
	public String getFstatus(String combine)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String querys = "Select status from Request where combine = :c1";
		String status = null;
		try {
			Query query = session.createQuery(querys);
			query.setParameter("c1",combine);
			List l = query.list();
			Iterator it = l.iterator();
			if(it.hasNext())
			{
				Object o[] = (Object[])it.next();
				status = (String)o[0];
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("getFstatus run successfully");
		return status;
		
	}
	public RegistrationTDto[] checkDetails(String stream,RegistrationTDto[] trdto)
	{
		Session session = this.sessionFactory.getCurrentSession();
		final String qry="Select t.fname,t.lname,t.subject,t.gender,t.cno,t.file,t.email,t.ratings,r.status from Teacher t, Request r where t.email=r.email and t.stream=:s1";
		
		int i=0;
		try
		{
			SQLQuery query = session.createSQLQuery(qry);
			query.setParameter("s1",stream);
			List l = query.list();
			Iterator it = l.iterator();
			while(it.hasNext()&& i<trdto.length)
			{
				System.out.println("It is running my brother");
				Object o[] = (Object[])it.next();
				trdto[i] = new RegistrationTDto();
				trdto[i].setFname((String)o[0]);
				trdto[i].setLname((String)o[1]);
				trdto[i].setSubject((String)o[2]);
				trdto[i].setGender((String)o[3]);
				trdto[i].setCno((String)o[4]);
				trdto[i].setFile((String)o[5]);
				trdto[i].setEmail((String)o[6]);
				trdto[i].setRatings((Double)o[7]);
				trdto[i].setStatus((String)o[8]);
				i++;
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		logger.info("checkDetails run successfully");
		return trdto;
	}
public int checkStream(String stream)
{
	Session session = this.sessionFactory.getCurrentSession();
	final String qry="From Teacher where stream= :s1";
	int i=1;
	try
	{
		Query query = session.createQuery(qry);
		query.setParameter("s1",stream);
		List <Teacher> l = query.list();
		Iterator <Teacher> it = l.iterator();
		if(it.hasNext())
		{
			
			i++;
		}
		
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	logger.info("checkStream run successfully");
	return i;
}
public boolean saveRatings(int ratings, String email) {
	Session session = this.sessionFactory.getCurrentSession();
	final String querys ="update Request set ratings ='"+ratings+"'where email='"+email+"'";
	boolean res = false;
	try {
		System.out.println("Here we go"+email);
		SQLQuery query = session.createSQLQuery(querys);
		//query.setParameter("r1",ratings);
		//query.setParameter("e1",email);
		int a=query.executeUpdate();
		System.out.println("This is what called a value"+ a);
		if(a!=0)
		res = true;
	} catch (Exception e) {
		e.printStackTrace();
	}
	logger.info("saveRatings successfully");
	return res;
}

}