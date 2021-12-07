package lpnu.repository;


import lpnu.entity.Customer;
import lpnu.entity.Vehicle;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class VehicleRepository {
    private static Map<Long, Vehicle> vehicles = new HashMap<Long,Vehicle>();


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
        return vehicles.values().stream().collect(Collectors.toList());
    }
}
