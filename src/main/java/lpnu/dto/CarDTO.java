package lpnu.dto;

import lpnu.entity.enumeration.CarStatus;
import org.springframework.stereotype.Component;

@Component
public class CarDTO extends VehicleDTO{
    private CarStatus carStatus;

    public CarDTO() {
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

}
