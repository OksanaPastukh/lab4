package lpnu.resourse;

import lpnu.dto.CustomerDTO;
import lpnu.dto.NewCustomerDTO;
import lpnu.service.CustomerService;
import lpnu.service.impl.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CustomerResource {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDTO> getAllCustomers(){
        return customerService.getAllCustomers();
    }

    @PostMapping("/customers")
    public CustomerDTO createCustomer(@RequestBody @Validated final NewCustomerDTO newCustomerDTO){
        return customerService.createCustomer(newCustomerDTO);
    }
    @PutMapping("/customers")
    public CustomerDTO updateCustomer(@RequestBody @Validated final CustomerDTO customerDTO)
    {
        return customerService.updateCustomer(customerDTO);
    }
    @GetMapping("/customers/{id}")
    public CustomerDTO getCustomerById(@PathVariable final long id){
        return customerService.getCustomerById(id);
    }
}
