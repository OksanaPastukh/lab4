package lpnu.mapper;

import lpnu.dto.CarDTO;
import lpnu.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarToCarDTOMapper {
    public static CarDTO toDTO(Car car){
        CarDTO carDTO = new CarDTO();
        carDTO.setCarStatus(car.getCarStatus());

        return carDTO;
    }
}
