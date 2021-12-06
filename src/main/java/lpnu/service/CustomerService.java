package lpnu.service;

import lpnu.dto.CustomerDTO;
import lpnu.dto.NewCustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomers();
    CustomerDTO createCustomer(NewCustomerDTO newCustomerDTO);

}
