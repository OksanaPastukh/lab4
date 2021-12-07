package lpnu.repository;

import lpnu.dto.NewDriverDTO;
import lpnu.entity.Customer;
import lpnu.entity.Driver;
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
public class DriverRepository {
    private static Map<Long, Driver> drivers = new HashMap<Long,Driver>();
    private static String filename = "drivers.dat";

    @PostConstruct
    public static void init()
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            drivers=((HashMap<Long, Driver>)ois.readObject());

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            drivers = new HashMap<Long, Driver>();
        }
    }

    @PreDestroy
    public static void preDestroy()
    {
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(drivers);
            System.out.println("File has been written");
        }catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }


    public static long getNewId()
    {
        long id = drivers.keySet().stream()
                .mapToLong(v->v)
                .max()
                .orElse(0) + 1;
        return id ;
    }
    public static List<Driver> getAllCustomers(){
        return drivers.values().stream().collect(Collectors.toList());
    }

    public static Driver createDriver(NewDriverDTO newDriverDTO) {
        Driver driver = new Driver(newDriverDTO.getName(),
                newDriverDTO.getSurname(),newDriverDTO.getPhoneNumber());
        drivers.put(driver.getId(),driver);
        return  driver;
    }
    public static Driver getDriverById(long id)
    {
        if(!(drivers.keySet().contains(id))){

            throw new ServiceException(400,"Driver with this id not found");
        }
        Driver result= drivers.get(id);
        return result;
    }

}
