package com.INTStore.EcommerceSiteWithSpring.application.service;

//import com.INTStore.EcommerceSiteWithSpring.application.model.Address;
//import com.INTStore.EcommerceSiteWithSpring.application.model.Customer;
//import com.INTStore.EcommerceSiteWithSpring.application.repository.AddressRepository;
//import com.INTStore.EcommerceSiteWithSpring.application.repository.CustomerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CustomerService
//{
//    @Autowired
//    private CustomerRepository customerRepository;
//    @Autowired
//    private AddressRepository addressRepository;
//    public List<Customer> getAllCustomer()
//    {
//        return customerRepository.findAll();
//    }
//    public void saveNewCustomer(Customer customer)
//    {
//        Customer savedCustomer = null;
//        ResponseEntity response = null;
//        try {
//            String hashPassword=passwordEncoder.encode(customer.getPassword());
//            customer.setPassword(hashPassword);
//            savedCustomer = customerRepository.save(customer);
//            if (savedCustomer.getId() > 0) {
//                response = ResponseEntity
//                        .status(HttpStatus.CREATED)
//                        .body("Given user details are successfully registered");
//            }
//        } catch (Exception ex) {
//            response = ResponseEntity
//                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
//                    .body("An exception occured due to " + ex.getMessage());
//        }
//        return response;
//    }
//
//}
import com.INTStore.EcommerceSiteWithSpring.application.model.User;
import com.INTStore.EcommerceSiteWithSpring.application.repository.AddressRepository;
import com.INTStore.EcommerceSiteWithSpring.application.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public ResponseEntity<String> saveNewUser(User user) {
        try {
            String hashPassword = passwordEncoder.encode(user.getPassword());
            user.setPassword(hashPassword);
            User savedUser = userRepository.save(user);
            if (savedUser.getUserId() > 0) {
                return ResponseEntity
                        .status(HttpStatus.CREATED)
                        .body("Given user details are successfully registered");
            }
        } catch (Exception ex) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An exception occurred due to " + ex.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("Unable to register user");
    }
}
