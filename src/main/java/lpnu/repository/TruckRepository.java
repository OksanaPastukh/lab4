package lpnu.repository;

import lpnu.dto.NewCarDTO;
import lpnu.dto.NewTruckDTO;
import lpnu.entity.Car;
import lpnu.entity.Truck;
import lpnu.entity.Vehicle;
import lpnu.entity.enumeration.VehicleStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class TruckRepository {
    public static Truck createTruck(NewTruckDTO newTruckDTO) {
        Truck truck = new Truck(newTruckDTO.getNumberVehicle(),
                newTruckDTO.getLiftingСapacity());
        VehicleRepository.addVehicleToRepository(truck);
        return  truck;
    }
    public static List<Vehicle> getAllReadyTruck(){
        return  VehicleRepository.getAllVehicles().stream()
                .filter((truck) -> truck.getClass().getTypeName() == "lpnu.entity.Truck"
                        && truck.getVehicleStatus() == VehicleStatus.READY)
                .collect(Collectors.toList());
    }
}
