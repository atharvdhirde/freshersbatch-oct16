package com.customer_details.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

//import com.customer_details.model.AuthenticationRequest;
//import com.customer_details.model.AuthenticationResponse;
import com.customer_details.model.CarDetails;
import com.customer_details.model.Customer;
import com.customer_details.repository.CustomerRepository;
import com.customer_details.service.CustomerServiceImpl;
//import com.customer_details.service.MyUserDetailsService;
//import com.customer_details.util.JwtUtil;
import com.customer_details.utilities.GlobalResources;

@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
	
	private Logger logger = GlobalResources.getLogger(CustomerController.class);

//	@Autowired
//	private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private MyUserDetailsService userDetailsService;

	@Autowired
	private CustomerRepository customerRepository;

//	@Autowired
//	private JwtUtil jwtUtil;

	@Autowired
	private CustomerServiceImpl customerService;

    @CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer)
	{
		try {
			String methodName = "(addCustomer)";
			logger.info(methodName + "Called");
			System.out.println(customer);
			customerService.addCustomer(customer);
			return ResponseEntity.ok(customer);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	 @GetMapping("/get-customer/{username}")
	    public ResponseEntity<Customer> getCustomerByUsername(@PathVariable("username") String username) {
	        try {
	        	String methodName = "getCustomerByUsername()";
	    		logger.info(methodName + "Called");
	            Customer customer = customerService.findByUsername(username);
	            return new ResponseEntity<Customer>(customer,HttpStatus.OK);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	        }
	    }


	@GetMapping("/get-all-customer")
	public ResponseEntity<List<Customer>> getAllCustomer() {
		return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
	}

	@PutMapping("/update-profile/{username}")
	public ResponseEntity<Customer> updateProfile(@PathVariable("username") String username,
												  @RequestBody Customer customer) {

		return new ResponseEntity<Customer>(customerService.updateProfile(customer, username), HttpStatus.OK);

	}

	@PostMapping("/car-details")
	public ResponseEntity<CarDetails> addCarDetails(@RequestBody CarDetails carDetails)
	{
		try {
			String methodName = "(addCarDetails)";
			logger.info(methodName + "Called");
			System.out.println(carDetails);
			customerService.addCarDetails(carDetails);
			return ResponseEntity.ok(carDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}




	//SECURITY REST APIS

//	@PostMapping("/authenticate") // Authenticate a Customer (Existing)
//	public ResponseEntity<?> generateToken(@RequestBody AuthenticationRequest authRequest) throws Exception {
//		try {
//			authenticationManager.authenticate(
//					new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
//			);
//		}catch (BadCredentialsException e) {
//			throw new Exception("Invalid Username or Password!",e);
//		}
//		UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUsername());
//		String token = jwtUtil.generateToken(userDetails);
//		return ResponseEntity.ok(new AuthenticationResponse(token));
//	}


//	@GetMapping("/current-user")
//	public Object getCurrentUser(Authentication authentication){
//		return authentication.getPrincipal();
//	}

}
