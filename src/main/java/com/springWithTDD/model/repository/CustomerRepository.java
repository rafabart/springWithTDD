package com.springWithTDD.model.repository;

import com.springWithTDD.model.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCpf(final String cpf);

    Optional<Customer> findByPhoneListDddAndPhoneListNumber(final String phoneDdd, final String phoneNumber);
}
