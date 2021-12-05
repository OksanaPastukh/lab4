package lpnu.service.impl;

import lpnu.dto.CustomerDTO;
import lpnu.mapper.CustomerToCustomerDTOMapper;
import lpnu.repository.CustomerRepository;
import lpnu.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerToCustomerDTOMapper customerDTOMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerToCustomerDTOMapper customerDTOMapper) {
        this.customerRepository = customerRepository;
        this.customerDTOMapper = customerDTOMapper;
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
      return  customerRepository.getAllCustomers().stream()
              .map(e -> customerDTOMapper.toDTO(e))
              .collect(Collectors.toList());
    }

}
