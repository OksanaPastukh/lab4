package lpnu.mapper;

import lpnu.dto.CarDTO;
import lpnu.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarToCarDTOMapper {
    public static CarDTO toDTO(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setCarStatus(car.getCarStatus());
        carDTO.setId(car.getId());
        carDTO.setNumberVehicle(car.getNumberVehicle());
        carDTO.setVehicleStatus(car.getVehicleStatus());
        carDTO.setDriverId((car.getDriver())==null?0:car.getDriver().getId());
        carDTO.setDriverName((car.getDriver())==null?"":
                car.getDriver().getSurname()+" "+car.getDriver().getName());

        return carDTO;
    }
}
