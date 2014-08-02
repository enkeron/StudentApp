package net.start.amg.customer;

public interface CustomerDAO {
	public void insert(Customer customer);
	public Customer findByCustomerId(int custId);
}
