package com.banking.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.banking.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{

}
