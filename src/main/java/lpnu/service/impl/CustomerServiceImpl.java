package lpnu.service.impl;

import lpnu.dto.CustomerDTO;
import lpnu.dto.NewCustomerDTO;
import lpnu.entity.Customer;
import lpnu.mapper.CustomerToCustomerDTOMapper;
import lpnu.repository.CustomerRepository;
import lpnu.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public List<CustomerDTO> getAllCustomers() {
      return  CustomerRepository.getAllCustomers().stream()
              .map(e -> CustomerToCustomerDTOMapper.toDTO(e))
              .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO createCustomer(NewCustomerDTO newCustomerDTO) {

        Customer customer = CustomerRepository.createCustomer(newCustomerDTO);
        return CustomerToCustomerDTOMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {

        final Customer customer = CustomerRepository.getCustomerById(customerDTO.getId());
        //todo add exception if customer = null
        //todo add exception if customerdto.phonenumber not uniqule
        customer.setName(customerDTO.getName());
        customer.setSurname(customerDTO.getSurname());
        customer.setPhoneNumber(customerDTO.getPhoneNumber());
        customer.setCustomerStatus(customerDTO.getCustomerStatus());

        return CustomerToCustomerDTOMapper.toDTO(customer);
    }

    @Override
    public CustomerDTO getCustomerById(long id) {
        return CustomerToCustomerDTOMapper.toDTO(CustomerRepository.getCustomerById(id));
    }
}
