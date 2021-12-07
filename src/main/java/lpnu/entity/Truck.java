package lpnu.entity;

import org.springframework.stereotype.Component;

@Component
public class Truck extends Vehicle{
    private int liftingСapacity;

    private Truck() {}

    public Truck(String numberVehicle, int liftingСapacity) {
        super(numberVehicle);
        this.liftingСapacity = liftingСapacity;
    }

    public int getLiftingСapacity() {
        return liftingСapacity;
    }

    public void setLiftingСapacity(int liftingСapacity) {
        this.liftingСapacity = liftingСapacity;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                "liftingСapacity=" + liftingСapacity +
                '}';
    }
}
