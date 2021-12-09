package lpnu.repository;

import lpnu.dto.NewOrderDTO;
import lpnu.entity.Customer;
import lpnu.entity.Driver;
import lpnu.entity.Order;
import lpnu.entity.Vehicle;
import lpnu.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class OrderRepository {
    private static Map<Long, Order> orders = new HashMap<Long,Order>();
    private static String filename = "orders.dat";

    @PostConstruct
    public static void init()
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            orders=((HashMap<Long, Order>)ois.readObject());

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            orders = new HashMap<Long, Order>();
        }
    }


    @PreDestroy
    public static void preDestroy()
    {
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(orders);
            System.out.println("File has been written");
        }catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public static long getNewId()
    {
        long id = orders.keySet().stream()
                .mapToLong(v->v)
                .max()
                .orElse(0) + 1;
        return id ;
    }

    public static Order createOrder(NewOrderDTO newOrderDTO) {
        Customer customer = CustomerRepository.getCustomerById(newOrderDTO.getCustomerId());
        Order order = new Order(customer,
                newOrderDTO.getVehicleType(),
                newOrderDTO.getAddressTo(),newOrderDTO.getAddressFrom());
        orders.put(order.getId(),order);
        return  order;
    }

    public static List<Order> getAllOrders() {
        return orders.values().stream()
                .collect(Collectors.toList());
    }

    public static Order getOrderById(long id)
    {
        if(!(orders.keySet().contains(id))){

            throw new ServiceException(400,"Order with this id not found");
        }
        Order result= orders.get(id);
        return result;
    }
}
