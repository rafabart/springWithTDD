package com.springWithTDD.service;

import com.springWithTDD.model.repository.CustomerRepository;
import com.springWithTDD.model.entity.Customer;
import com.springWithTDD.model.entity.Phone;
import com.springWithTDD.model.exception.PhoneNotFindException;
import com.springWithTDD.model.exception.UniquenessCpfException;
import com.springWithTDD.model.exception.UniquenessPhoneException;
import com.springWithTDD.model.service.CustomerService;
import com.springWithTDD.model.service.impl.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


//Delega ao Spring a execução dos teste
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    private static final String NAME = "Xablau";
    private static final String CPF = "11122233344";
    private static final String DDD = "00";
    private static final String PHONE_NUMBER = "12345678";


    @MockBean
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    private Customer customer;

    private Phone phone;


    @Before
    public void setUp() throws Exception {

        customerService = new CustomerServiceImpl(customerRepository);

        phone = new Phone(DDD, PHONE_NUMBER);

        customer = new Customer(NAME, CPF);
        customer.setPhoneList(Collections.singletonList(phone));

    }


    @Test
    public void must_create_customer_in_repository() throws Exception {

        customerService.create(customer);

        // Verifica se o método 'save' foi acionado na instância 'customerRepository'.
        verify(customerRepository).save(customer);
    }


    // Só passa no teste se lançar a exceção definida em expected.
    @Test(expected = UniquenessCpfException.class)
    public void should_not_create_two_customers_with_some_cpf_in_repository() throws Exception {

        // Retorno do método 'findByCpf' pré definido.
        when(customerRepository.findByCpf(CPF)).thenReturn(Optional.of(customer));

        customerService.create(customer);
    }


    @Test(expected = UniquenessPhoneException.class)
    public void should_not_create_two_customers_with_some_phone_in_repository() throws Exception {

        when(customerRepository.findByPhoneListDddAndPhoneListNumber(DDD, PHONE_NUMBER)).thenReturn(Optional.of(customer));

        customerService.create(customer);
    }


    @Test(expected = PhoneNotFindException.class)
    public void should_not_find_customer_by_phone_in_repository() throws Exception {

        customerService.findByPhone(phone);

        verify(customerRepository).findByPhoneListDddAndPhoneListNumber(DDD, PHONE_NUMBER);

    }


    @Test
    public void most_find_customer_by_phone_in_repository() throws Exception {

        when(customerRepository.findByPhoneListDddAndPhoneListNumber(DDD, PHONE_NUMBER)).thenReturn(Optional.of(customer));

        Customer customerTest = customerService.findByPhone(phone);

        verify(customerRepository).findByPhoneListDddAndPhoneListNumber(DDD, PHONE_NUMBER);

        assertThat(customerTest).isNotNull();
        assertThat(customerTest.getName()).isEqualTo(NAME);
        assertThat(customerTest.getCpf()).isEqualTo(CPF);
    }


}
