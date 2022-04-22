package com.customer_details.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer_details.exceptions.CustomerNotFoundException;
import com.customer_details.exceptions.allFieldsAreNeccessary;
//import com.customer_details.exceptions.userNameAlreadyExists;
import com.customer_details.model.CarDetails;
import com.customer_details.model.Customer;
import com.customer_details.model.RatingReview;
import com.customer_details.repository.CarDetailsRepository;
import com.customer_details.repository.CustomerRepository;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private CarDetailsRepository carDetailsRepository;

	@Override
	public Customer findByUsername(String username) {
		Customer customer = customerRepository
                .findAll()
                .stream()
                .filter(a -> a.getUsername().equalsIgnoreCase(username))
                .findAny().orElse(null);
		if (customer == null) {
			throw new CustomerNotFoundException("Sorry, Customer with the provided Username not found" +
					",Please provide the correct Username");
		}
		else {
			return customerRepository.findByUsername(username);
		}
	}

	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customer = customerRepository.findAll();
		return customer;
	}

//	@Override
//	public Customer addCustomer(Customer customer) {
//
//		customer.setProfile("default.png");
//		customer.setRole("Customer");
//		Customer customer1 = this.customerRepository.findByUsername(customer.getUsername());
//		if (customer1 != null) {
//			System.out.println("Customer is already there !!");
//			throw new userNameAlreadyExists("Username already present!!!");

		//}
//		else {
//		System.out.println(customer);
//		return customerRepository.save(customer);
//		}
	//}

	@Override
	public Customer updateProfile(Customer customer, String username) {
		Customer existingCustomer = customerRepository.findByUsername(username);

		existingCustomer.setUsername(customer.getUsername());
		existingCustomer.setPassword(customer.getPassword());
		existingCustomer.setName(customer.getName());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setEmail(customer.getEmail());
		existingCustomer.setPhone(customer.getPhone());
		existingCustomer.setRole(customer.getRole());
		customerRepository.save(existingCustomer);

		return existingCustomer;
	}

	@Override
	public RatingReview giveRatingAndReview(RatingReview ratingReview) {
		return null;
	}

	@Override
	public CarDetails addCarDetails(CarDetails carDetails) {
		return carDetailsRepository.save(carDetails);
	}

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return null;
	}


}
