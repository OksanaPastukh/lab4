package lpnu.repository;


import lpnu.entity.Customer;
import lpnu.entity.Driver;
import lpnu.entity.Vehicle;
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
public class VehicleRepository {
    private static Map<Long, Vehicle> vehicles = new HashMap<Long,Vehicle>();
    private static String filename = "vehicles.dat";

    @PostConstruct
    public static void init()
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename)))
        {
            vehicles=((HashMap<Long, Vehicle>)ois.readObject());

        }catch(Exception ex){
            System.out.println(ex.getMessage());
            vehicles = new HashMap<Long, Vehicle>();
        }
    }
    @PreDestroy
    public static void preDestroy()
    {
        try(ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream(filename))){
            oos.writeObject(vehicles);
            System.out.println("File has been written");
        }catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }


    public static long getNewId()
    {
        long id = vehicles.keySet().stream()
                .mapToLong(v->v)
                .max()
                .orElse(0) + 1;
        return id ;
    }

    protected static void addVehicleToRepository(Vehicle vehicle) {

        vehicles.put(vehicle.getId(),vehicle);
    }
    public static List<Vehicle> getAllVehicles(){
        return vehicles.values().stream()
                .collect(Collectors.toList());
    }
    public static Vehicle getVehicleById(long id)
    {
        if(!(vehicles.keySet().contains(id))){//todo add exception

            throw new ArithmeticException();
        }
        Vehicle result= vehicles.get(id);
        return result;
    }
}
