package lpnu.repository;

import lpnu.dto.NewCarDTO;
import lpnu.dto.NewTruckDTO;
import lpnu.entity.Car;
import lpnu.entity.Truck;
import org.springframework.stereotype.Repository;

@Repository
public class TruckRepository {
    public static Truck createTruck(NewTruckDTO newTruckDTO) {
        Truck truck = new Truck(newTruckDTO.getNumberVehicle(),
                newTruckDTO.getLiftingСapacity());
        VehicleRepository.addVehicleToRepository(truck);
        return  truck;
    }
}
