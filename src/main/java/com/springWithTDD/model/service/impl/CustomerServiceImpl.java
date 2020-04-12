package com.springWithTDD.model.service.impl;

import com.springWithTDD.model.entity.Customer;
import com.springWithTDD.model.entity.Phone;
import com.springWithTDD.model.exception.PhoneNotFindException;
import com.springWithTDD.model.exception.UniquenessCpfException;
import com.springWithTDD.model.exception.UniquenessPhoneException;
import com.springWithTDD.model.repository.CustomerRepository;
import com.springWithTDD.model.service.CustomerService;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    public CustomerServiceImpl(final CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer create(final Customer customer) throws Exception {

        if (customerRepository.findByCpf(customer.getCpf()).isPresent()) {
            throw new UniquenessCpfException();
        }

        final String ddd = customer.getPhoneList().get(0).getDdd();
        final String number = customer.getPhoneList().get(0).getNumber();

        if (customerRepository.findByPhoneListDddAndPhoneListNumber(ddd, number).isPresent()) {
            throw new UniquenessPhoneException();
        }

        return customerRepository.save(customer);
    }

    @Override
    public Customer findByPhone(final Phone phone) throws Exception {

        return customerRepository.findByPhoneListDddAndPhoneListNumber(phone.getDdd(), phone.getNumber()).orElseThrow(PhoneNotFindException::new);
    }

}
