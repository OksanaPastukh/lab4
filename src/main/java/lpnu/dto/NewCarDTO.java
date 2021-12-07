package lpnu.dto;

import lpnu.entity.enumeration.CarStatus;
import org.springframework.stereotype.Component;

@Component
public class NewCarDTO extends NewVehicleDTO{
    private CarStatus carStatus;

    public NewCarDTO() {
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }


}
