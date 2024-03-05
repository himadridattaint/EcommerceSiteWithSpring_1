package com.INTStore.EcommerceSiteWithSpring.application.service;

import com.INTStore.EcommerceSiteWithSpring.application.model.Address;
import com.INTStore.EcommerceSiteWithSpring.application.model.User;
import com.INTStore.EcommerceSiteWithSpring.application.repository.AddressRepository;
import com.INTStore.EcommerceSiteWithSpring.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService
{
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserRepository userRepository;
    public List<Address> getAllAddresses()
    {
        return addressRepository.findAll();
    }
    public void saveNewAddress(Address address,Long id) {
        try {
            User c = userRepository.findById(id).orElse(null);
            Address a = new Address();
            a.setStreet(address.getStreet());
            a.setState(address.getState());
            a.setPincode(address.getPincode());
            a.setCountry(address.getCountry());

            a.getUsers().add(c);
            addressRepository.save(a);
            c.getAddresses().add(a);
            userRepository.save(c);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }




}

