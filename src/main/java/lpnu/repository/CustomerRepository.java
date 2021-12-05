package lpnu.repository;

import lpnu.dto.CustomerDTO;
import lpnu.entity.Customer;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerRepository {
    private List<Customer> customers;

    @PostConstruct
    public void init(){
        customers = new ArrayList<>();
        customers.add(new Customer("one"));
        customers.add(new Customer("two"));
    }
    public List<Customer> getAllCustomers(){return new ArrayList<>(customers);
    }
}
