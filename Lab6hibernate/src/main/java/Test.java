import java.sql.SQLException;
import java.util.HashSet;

import th.ac.ku.kps.eng.cpe.dao.CustomerDAO;
import th.ac.ku.kps.eng.cpe.soa.model.Customer;


public class Test {
	public static void main(String[] args) throws SQLException {
		CustomerDAO c = new CustomerDAO();
		//c.addCustomer(new Customer("S1", new HashSet<Phonenumber>()));
		for (Customer cs : c.getAllCustomers())
			System.out.println(cs.getName());
	}
}
