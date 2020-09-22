package guru.springframework.msscbrewery.services;

import guru.springframework.msscbrewery.web.model.CustomerDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {
    public CustomerDTO getCustomerById(UUID customerId) {
        return CustomerDTO.builder()
                .id(customerId)
                .name("Arkadiy Derevyan")
                .build();
    }

    @Override
    public CustomerDTO saveNewCustomer(CustomerDTO customerDTO) {
        customerDTO.setId(UUID.randomUUID());
        log.info("Created customer: "+customerDTO);
        return customerDTO;
    }

    @Override
    public void updateCustomer(UUID customerId,CustomerDTO customerDTO) {
        log.info("Updated customer: "+customerDTO.toString());
    }

    @Override
    public void deleteById(UUID customerId) {
        log.info("Deleted customer: "+customerId.toString());
    }
}
