package lpnu.entity;

import lpnu.entity.enumeration.CarStatus;
import org.springframework.stereotype.Component;

@Component
public class Car extends Vehicle{
   private CarStatus carStatus;

    private Car() {
    }

    public Car(String numberVehicle, CarStatus carStatus) {
        super(numberVehicle);
        this.carStatus = carStatus;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString()+
                "carStatus=" + carStatus +
                '}';
    }

}
