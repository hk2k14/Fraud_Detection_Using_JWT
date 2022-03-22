package com.mycompany.app.customer;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Data
@Service
public class CustomerService {

    public final CustomerRepository customerRepository;

    public final RestTemplate restTemplate;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate){
        this.customerRepository = customerRepository;
        this.restTemplate = restTemplate;
    }


    public void registerCustomer(CustomerRegistrationRequest request) {

        Customer customer = Customer.builder().firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        customerRepository.saveAndFlush(customer);

        FraudCheckResponse fraudCheckResponse = restTemplate.getForObject(
                "http://localhost:8091/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,
                customer.getId());

        if(fraudCheckResponse.getIsFraudster())
        {
            throw new IllegalStateException("Fraudster");
        }
    }
}
