package com.springWithTDD.repository;

import com.springWithTDD.model.repository.CustomerRepository;
import com.springWithTDD.model.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

// Teste de integração.

// Avisa o Spring que essa classe de teste vai usar um banco de dados.
@DataJpaTest
// Informa ao Spring onde esta a configuração do banco de dados.
@TestPropertySource("classpath:application-test.yml")
// Carrega o arquivo SQL no banco antes de executar o teste.
@Sql(value = "/load-database.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
// Carrega o arquivo SQL no banco antes de executar o teste.
@Sql(value = "/clean-database.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {


    @Autowired
    private CustomerRepository customerRepository;


    @Test
    public void must_find_customer_by_cpf() throws Exception {

        Optional<Customer> optionalCustomer = customerRepository.findByCpf("38767897100");

        assertThat(optionalCustomer.isPresent()).isTrue();

        final Customer customer = optionalCustomer.get();

        assertThat(customer.getId()).isEqualTo(3L);
        assertThat(customer.getName()).isEqualTo("Caue");
        assertThat(customer.getCpf()).isEqualTo("38767897100");
    }

    @Test
    public void should_not_find_customer_by_nonexistent_cpf() throws Exception {

        Optional<Customer> optionalCustomer = customerRepository.findByCpf("8767897100");

        assertThat(optionalCustomer.isPresent()).isFalse();
    }
}
