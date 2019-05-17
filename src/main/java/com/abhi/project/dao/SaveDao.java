package com.abhi.project.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import com.abhi.project.dto.*;

@Repository
public class SaveDao {

	private static final Logger logger = LoggerFactory.getLogger(SaveDao.class);

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sf) {

		this.sessionFactory = sf;
	}

	final String querys = "from Student where rollno = :r1 and pwd = :p1";
	final String querys3 = "update  Student set image = :img" + " where rollno= :r1";

	public boolean save(RegistrationDto rdto) {

		System.out.println("1 is working");
		Session session = this.sessionFactory.getCurrentSession();
		String rollno = rdto.getRollno();
		String pwd = rdto.getPwd();
		java.util.Date dob = rdto.getDob();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy ");
		String sdob = dateFormat.format(dob);
		java.util.Date twpy = rdto.getTwpy();
		String stwpy = dateFormat.format(twpy);
		java.util.Date tpy = rdto.getTpy();
		String stpy = dateFormat.format(tpy);
		boolean res = false;
		try {
			System.out.println("2 is working");
		
			  Query query = session.createQuery(querys); 
			  query.setParameter("r1", rollno);
			  query.setParameter("p1", pwd); 
			  List<Student> l = query.list();
			  System.out.println(l.size());
			  Iterator<Student> it = l.iterator();
			 System.out.println("3 is working"); 
			 if(it.hasNext())
			 //if(l!=null)
			 { 
				 res = false; 
			 } 
			 else 
			 {
			Student sdto = new Student();
			System.out.println("its working fine");
			sdto.setRollno(rollno);
			sdto.setPwd(pwd);
			sdto.setEmail(rdto.getEmail());
			sdto.setCno(rdto.getCno());
			sdto.setFname(rdto.getFname());
			sdto.setLname(rdto.getLname());
			sdto.setDob(sdob);
			sdto.setTpy(stpy);
			sdto.setTwpy(stwpy);
			sdto.setGender(rdto.getGender());
			sdto.setStream(rdto.getStream());
			sdto.setTwsname(rdto.getTwsname());
			sdto.setTsname(rdto.getTsname());
			sdto.setTper(rdto.getTper());
			sdto.setTwper(rdto.getTwper());
			sdto.setAddress(rdto.getAddress());
			session.save(sdto);
			res = true;
			session.beginTransaction().commit();
			 }
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("save run successfully");
		System.out.println(res);
		return res;
	}

	public boolean saveImage(RegistrationDto rdto) {
		Session session = this.sessionFactory.getCurrentSession();
		String rollno = rdto.getRollno();
		System.out.println(rollno);
		String pwd = rdto.getPwd();
		boolean res = false;
		try {
			Query query = session.createQuery(querys);
			query.setParameter("r1", rollno);
			query.setParameter("p1", pwd);
			List<Student> l = query.list();
			Iterator<Student> it = l.iterator();
			if (it.hasNext()) {
				System.out.println("yes it is working");
				Query query1 = session.createQuery(querys3);
				query1.setParameter("img", rdto.getImage());
				query1.setParameter("r1", rollno);
				int a = query1.executeUpdate();
				if (a != 0)
					res = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("saveImage successfully");
		return res;
	}

	public boolean saveFstatus(String rollno, String tmail, String combine) {
		Session session = this.sessionFactory.getCurrentSession();
		String querys1 = "from Request where combine = :c1";
		boolean res = false;
		try {
			Query query = session.createQuery(querys1);
			query.setParameter("c1", combine);
			List<Request> l = query.list();
			Iterator<Request> it = l.iterator();
			System.out.println("friend status function is running");
			if (it.hasNext()) {
				res = false;
			} else {
				Request frdto = new Request();
				frdto.setCombine(combine);
				frdto.setRollno(rollno);
				frdto.setEmail(tmail);
				session.save(frdto);
				res = true;
				session.beginTransaction().commit();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("saveFstatus successfully");
		return res;
	}

	

}
