package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDTO;

import java.util.UUID;

public interface CustomerService {
    public CustomerDTO getCustomerById(UUID customerId);
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO);
    public void updateCustomer(UUID customerId,CustomerDTO customerDTO);
    public void deleteById(UUID customerId);
}
