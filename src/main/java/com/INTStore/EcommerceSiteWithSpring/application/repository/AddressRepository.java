package com.INTStore.EcommerceSiteWithSpring.application.repository;

import com.INTStore.EcommerceSiteWithSpring.application.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  AddressRepository extends JpaRepository<Address,Long>
{

}
