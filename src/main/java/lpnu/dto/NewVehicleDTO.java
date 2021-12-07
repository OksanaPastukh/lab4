package lpnu.dto;

import lpnu.entity.Driver;
import org.springframework.stereotype.Component;

@Component
public abstract class NewVehicleDTO {
    private String numberVehicle;


    public NewVehicleDTO() {
    }

    public String getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(String numberVehicle) {
        this.numberVehicle = numberVehicle;
    }


}
