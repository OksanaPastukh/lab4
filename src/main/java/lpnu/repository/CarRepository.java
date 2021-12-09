package lpnu.repository;

import lpnu.dto.NewCarDTO;
import lpnu.entity.Car;

import lpnu.entity.Vehicle;
import lpnu.entity.enumeration.VehicleStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {

    public static Car createCar(NewCarDTO newCarDTO) {
        Car car = new Car(newCarDTO.getNumberVehicle(),
                newCarDTO.getCarStatus());
        VehicleRepository.addVehicleToRepository(car);
        return  car;
    }
    public static List<Vehicle> getAllReadyCar(){
       return  VehicleRepository.getAllVehicles().stream()
                .filter((cars) -> cars.getClass().getTypeName() == "lpnu.entity.Car"
                && cars.getVehicleStatus() == VehicleStatus.READY)
                .collect(Collectors.toList());
    }
}
