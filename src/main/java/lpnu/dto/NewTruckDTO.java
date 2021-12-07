package lpnu.dto;

import org.springframework.stereotype.Component;

@Component
public class NewTruckDTO extends NewVehicleDTO{
    private int liftingСapacity;

    public NewTruckDTO() {
    }

    public int getLiftingСapacity() {
        return liftingСapacity;
    }

    public void setLiftingСapacity(int liftingСapacity) {
        this.liftingСapacity = liftingСapacity;
    }

}
