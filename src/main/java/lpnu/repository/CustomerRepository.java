package lpnu.repository;

import lpnu.dto.NewCustomerDTO;
import lpnu.entity.Customer;
//import org.springframework.asm.TypeReference;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CustomerRepository {
    private static Map<Long,Customer> customers = new HashMap<Long, Customer>();
    private static String filename = "customers.dat";

    @PostConstruct
    public static void init() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            customers=((HashMap<Long, Customer>)ois.readObject());

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            customers = new HashMap<Long, Customer>();
        }
    }

    @PreDestroy
    public static void preDestroy()
   {
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(customers);
            System.out.println("File has been written");
       }catch(Exception ex){

           System.out.println(ex.getMessage());
        }
    }
    public static long getNewId()
    {
        long id = customers.keySet().stream()
                .mapToLong(v->v)
                .max()
                .orElse(0) + 1;
        return id ;
    }
    public static List<Customer> getAllCustomers(){
        return customers.values().stream().collect(Collectors.toList());
    }

    public static Customer createCustomer(NewCustomerDTO newCustomerDTO) {
        Customer customer = new Customer(newCustomerDTO.getName(),
                newCustomerDTO.getSurname(),newCustomerDTO.getPhoneNumber());
        customers.put(customer.getId(),customer);
        return  customer;
    }

    public static Customer getCustomerById(long id)
    {
        if(!(customers.keySet().contains(id))){

            throw new ServiceException(400,"Customer with this id not found");
        }
        Customer result= customers.get(id);
        return result;
    }
    public static boolean isPhoneNumberUnique(final long customer_id,final int phoneNumber){
       return customers.values().stream()
                .noneMatch((customer) -> customer.getPhoneNumber() == phoneNumber
                  &&  customer.getId()!=customer_id);

    }

}
