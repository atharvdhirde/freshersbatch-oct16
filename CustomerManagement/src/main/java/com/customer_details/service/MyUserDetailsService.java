//package com.customer_details.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.customer_details.model.Customer;
//import com.customer_details.repository.CustomerRepository;
//
//import java.util.Arrays;
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private CustomerRepository customerRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        Customer customer = customerRepository.findByUsername(username);
//        if(customer != null) {
//            GrantedAuthority authority = new SimpleGrantedAuthority(customer.getRole());
//            return new User(customer.getUsername(), customer.getPassword(),Arrays.asList(authority));
//        }
//        else return new User(null,null,null);
//    }
//}
//
