package com.customer_details.service;

import java.util.List;

import com.customer_details.model.CarDetails;
import com.customer_details.model.Customer;
import com.customer_details.model.RatingReview;

public interface CustomerService {

	public Customer findByUsername(String username);

	public List<Customer> getAllCustomers();

	public Customer addCustomer(Customer customer);

	public Customer updateProfile(Customer customer, String username);

	public RatingReview giveRatingAndReview(RatingReview ratingReview);

	public CarDetails addCarDetails(CarDetails carDetails);

}
