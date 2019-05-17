package com.abhi.project.dao;
import java.text.DateFormat;
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
public class SaveTDao {
	
	private static final Logger logger = LoggerFactory.getLogger(SaveTDao.class);
	 private SessionFactory sessionFactory;
		
		public void setSessionFactory(SessionFactory sf){
			this.sessionFactory = sf;
		}
	final String querys= "from Teacher where email= :e1 and pwd= :p1";
	final String querys1="from Teacher where email= :e1 and pwd= :p1";
	final String querys3 = "update Teacher set image = :img" + " where email = :e1";
	final String querys4 = "update Teacher set file = :f1" + "where email = :e1 and pwd= :p1";
	
	
	public boolean save(RegistrationTDto rtdto)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String email=rtdto.getEmail();
		String pwd=rtdto.getPwd();
		java.util.Date dob=rtdto.getDob();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		String tdob = dateFormat.format(dob);
		boolean res = false;
		try {
			System.out.println("It is inside try");
			Query query = session.createQuery(querys);
			query.setParameter("e1",email);
			query.setParameter("p1",pwd);
			List<Teacher> l = query.list();
			Iterator<Teacher> it = l.iterator();
			if(it.hasNext())
			{
				res = false;
			}
			else
			{
				Teacher tdto = new Teacher();
				tdto.setEmail(email);
				tdto.setPwd(pwd);
				tdto.setCno(rtdto.getCno());
				tdto.setDob(tdob);
				tdto.setSubject(rtdto.getSubject());
				tdto.setStream(rtdto.getStream());
				tdto.setAddress(rtdto.getAddress());
				tdto.setGender(rtdto.getGender());
				tdto.setFname(rtdto.getFname());
				tdto.setLname(rtdto.getLname());
				session.save(tdto);
				res = true;
				session.beginTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("save run successfully");
		return res;
	}
	public boolean saveTImage(RegistrationTDto trdto)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String email=trdto.getEmail();
		System.out.println(email);
		String pwd=trdto.getPwd();
		String image=trdto.getTImage();
		System.out.println(image);
		boolean res = false;
		try {
			/*Query query = session.createQuery(querys);
			query.setParameter("e1",email);
			query.setParameter("p1",pwd);
			System.out.println("It is working properly");
			List <Teacher> l = query.list();
			Iterator <Teacher> it = l.iterator();*/
			
			System.out.println("It is working properly 2");
				Query query1 = session.createQuery(querys3);
				query1.setParameter("img",image);
				query1.setParameter("e1",email);
				int a = query1.executeUpdate();
				if (a != 0)
				res = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("saveTImage successfully");
		return res;
	}
	public boolean saveTFile(RegistrationTDto trdto)
	{
		Session session = this.sessionFactory.getCurrentSession();
		String email=trdto.getEmail();
		String pwd =trdto.getPwd();
	    String subject =trdto.getSubject();
		boolean res = false;
		try {
				Query query1 = session.createQuery(querys4);
				query1.setParameter("f1",trdto.getFile());
				query1.setParameter("e1",email);
				query1.setParameter("p1",pwd);
				int a = query1.executeUpdate();
				if (a != 0)
				res = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("saveTfile run successfully");
		return res;
	}

	public double getRates (String email)
	{
		Session session = this.sessionFactory.getCurrentSession();
		double sum=0;
		int i=0;
		final String querys ="from Request where email= :e1";
		
		try {
			
			Query query = session.createQuery(querys);
			query.setParameter("e1",email);
			List<Request> r = query.list();
			Iterator<Request> it = r.iterator();
			while(it.hasNext())
			{
				Request re = it.next();
				i++;
				if(re.getRatings()!=0)
				sum = sum + re.getRatings();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(i>0)
		sum = sum/i;
		try {
			final String querys1 ="update Teacher set ratings ='"+sum + "'where email='"+email+"'";
			SQLQuery query = session.createSQLQuery(querys1);
			query.executeUpdate();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		logger.info("getRates run successfully");
		return sum;
	}
}
