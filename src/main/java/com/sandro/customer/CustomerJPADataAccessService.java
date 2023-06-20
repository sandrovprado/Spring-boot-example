package com.sandro.customer;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("jpa") //name for @Qualifier
public class CustomerJPADataAccessService implements CustomerDao{

    private final CustomerRepository customerRepository;

    public CustomerJPADataAccessService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> selectAllCustomers() {
        return customerRepository.findAll(); //function from JPA repo interface
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customerRepository.findById(id); //function from JPA repo interface
    }

    @Override
    public void insertCustomer(Customer customer) {
        customerRepository.save(customer); //function from JPA repo interface
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customerRepository.existsCustomersByEmail(email);

    }

    @Override
    public boolean existsPersonWithId(Integer customerId) {
        return customerRepository.existsCustomersById(customerId);
    }

    @Override
    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

    @Override
    public void updateCustomer(Customer update) {
        customerRepository.save(update);
    }
}
