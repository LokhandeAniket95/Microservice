package com.ani.company.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ani.company.model.CustomerDetails;

public interface CustomerRepository  extends JpaRepository<CustomerDetails, Long>{

}
