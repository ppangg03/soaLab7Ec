package th.ac.ku.kps.eng.cpe.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.TransactionException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import th.ac.ku.kps.eng.cpe.soa.model.Customer;
//import th.ac.ku.kps.eng.cpe.soa.model.Phonenumber;

public class CustomerDAO {
	public ArrayList<Customer> getAllCustomers() {
		Session session = SessionUtil.getSession();
		Query<Customer> query = session.createQuery("from Customer");
		ArrayList<Customer> customers = (ArrayList<Customer>) query.list();
		session.close();
		return customers;
	}
	public boolean addCustomer(Customer c) {
		try {
			Session session = SessionUtil.getSession();
			Transaction tx = session.beginTransaction();
			tx.begin();
			session.save(c);
			tx.commit();
			session.close();
		} catch (TransactionException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public Customer findCustomerByName(String name) {
		Session session = SessionUtil.getSession();
		Query query = session.createQuery("from Customer where name=:name");
		query.setParameter("name",name);
		if(query.list().size()==0)
			return null;
		return (Customer) query.list();
	 }
	public Customer findCustomer(String userName) {
		Session session = SessionUtil.getSession();
		//Criteria cr = session.createQuery("from Customer where username='"+userName+"'");
		//Criteria cr = (Criteria) session.createCriteria(userName);
		Query cr = session.createQuery("from Customer where username='"+userName+"'");
		return (Customer) cr.list().get(0);
	}
	public Customer findCustomer(Customer c) {
		Session session = SessionUtil.getSession();
		Criteria cr = session.createCriteria(Customer.class);
		cr.add(Restrictions.eq("username",c.getUsername()));
		cr.add(Restrictions.eq("pwd",c.getPwd()));
		
		if(cr.list().size()==0) return null;
		
		return (Customer) cr.list().get(0);	
	}
	
}