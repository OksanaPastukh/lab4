package lpnu.repository;

import lpnu.dto.NewCarDTO;
import lpnu.dto.NewCustomerDTO;
import lpnu.entity.Car;
import lpnu.entity.Customer;
import org.springframework.stereotype.Repository;

@Repository
public class CarRepository {

    public static Car createCar(NewCarDTO newCarDTO) {
        Car car = new Car(newCarDTO.getNumberVehicle(),
                newCarDTO.getCarStatus());
        VehicleRepository.addVehicleToRepository(car);
        return  car;
    }
}
