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
        customerDTO.setName(customer.getName().toUpperCase(Locale.ROOT));
        return customerDTO;
    }
}
