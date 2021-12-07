package lpnu.dto;

import org.springframework.stereotype.Component;

@Component
public class TruckDTO extends VehicleDTO{
    private int liftingСapacity;

    public TruckDTO(){}

    public int getLiftingСapacity() {
        return liftingСapacity;
    }

    public void setLiftingСapacity(int liftingСapacity) {
        this.liftingСapacity = liftingСapacity;
    }

}
