package lpnu.mapper;

import lpnu.dto.CustomerDTO;
import lpnu.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CustomerToCustomerDTOMapper {
    public static CustomerDTO toDTO(Customer customer)
    {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName().toUpperCase(Locale.ROOT));
        customerDTO.setSurname(customer.getSurname());
        customerDTO.setPhoneNumber(customer.getPhoneNumber());
        customerDTO.setCustomerStatus(customer.getCustomerStatus());
        return customerDTO;

    }
}
