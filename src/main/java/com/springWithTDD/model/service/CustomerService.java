package com.springWithTDD.model.service;

import com.springWithTDD.model.entity.Customer;
import com.springWithTDD.model.entity.Phone;
import com.springWithTDD.model.exception.PhoneNotFindException;


public interface CustomerService {

    Customer create(final Customer customer) throws Exception;

    Customer findByPhone(final Phone phone) throws Exception;
}
