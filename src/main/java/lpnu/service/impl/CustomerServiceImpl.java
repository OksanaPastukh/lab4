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


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;

    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
      return  customerRepository.getAllCustomers().stream()
              .map(e -> CustomerToCustomerDTOMapper.toDTO(e))
              .collect(Collectors.toList());
    }

}
