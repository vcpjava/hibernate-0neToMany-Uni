package com.vcp.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.vcp.domain.PhoneNumbers;
import com.vcp.domain.Users;
import com.vcp.utility.HibernateUtil;

public class OToManyDaoImpl implements OToManyDAO {

	public void save() {
		// TODO Auto-generated method stub
		Transaction tx = null;
		// get Session
		Session ses = null;
		ses = HibernateUtil.getSession();
		tx = ses.beginTransaction();

		// create parent class obj
		Users user = new Users();
		user.setUserId(102);
		user.setFirstName("Shankar");
		user.setLastName("Reddy");
		user.setEmail("sankar@gmail.com");

		Set<PhoneNumbers> childs = new HashSet<PhoneNumbers>();

		// create child class objects
		PhoneNumbers ph = new PhoneNumbers();
		ph.setPhoneNumber(8989766756L);
		ph.setNymberType("ofc");
		ph.setProvider("jio");

		childs.add(ph);

		PhoneNumbers ph1 = new PhoneNumbers();
		ph1.setPhoneNumber(9874567830L);
		ph1.setNymberType("personal");
		ph1.setProvider("idea");

		childs.add(ph1);

		// store child objs in parent objs
		user.setPhoneNumbers(childs);

		try {
			ses.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
		// close session
		HibernateUtil.closeSession();
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		Session ses = null;
		// get Session
		ses = HibernateUtil.getSession();
		Users user = ses.get(Users.class, 101);
		Set<PhoneNumbers> phones = user.getPhoneNumbers();
		for (PhoneNumbers ph : phones) {
			System.out.println("Phones::" + ph);
		}
		//close session
		HibernateUtil.closeSession();
	}

	@Override
	public void addNewNumberToExistingUser() {
		// TODO Auto-generated method stub
		Session ses = null;
		// get Session
		ses = HibernateUtil.getSession();
		Users user = ses.get(Users.class, 101);
		Set<PhoneNumbers> phones = user.getPhoneNumbers();
		
		//create child class Object
		PhoneNumbers ph = new PhoneNumbers();
		ph.setPhoneNumber(7789066890L);
		ph.setNymberType("personal");
		ph.setProvider("vodafone");
		
		Transaction tx = null;
		tx = ses.beginTransaction();
		
		try {
			phones.add(ph);
			tx.commit();
			System.out.println("new child is added");
		}catch(Exception e) {
			tx.rollback();
		}
			HibernateUtil.closeSession();	
	}

	@Override
	public void deleteUserWithPhoneNumbers() {
		// TODO Auto-generated method stub
		Session ses = null;
		// get Session
		ses = HibernateUtil.getSession();
		Users user = ses.get(Users.class, 101);
		
		Transaction tx = null;
		tx = ses.beginTransaction();
		
		try {
			ses.delete(user);
			tx.commit();
			System.out.println("user deleted   "+user.getUserId());
		}catch(Exception e) {
			tx.rollback();
		}
		HibernateUtil.getSession();
	}

	@Override
	public void deleteOnePhoneNumberOfAUser() {
		// TODO Auto-generated method stub
		Session ses = null;
		// get Session
		ses = HibernateUtil.getSession();
		Users user = ses.get(Users.class, 102);
		Set<PhoneNumbers> phones = user.getPhoneNumbers();
		//create chils class Object 
		PhoneNumbers ph = ses.get(PhoneNumbers.class, 9874567830L);
		Transaction tx = null;
		tx = ses.beginTransaction();
		try {
			phones.remove(ph);
			tx.commit();
			System.out.println("PhoneNumber deleted "+ph.getPhoneNumber());
		}catch(Exception e) {
			tx.rollback();
		}
		HibernateUtil.getSession();
		
		
	}

}
