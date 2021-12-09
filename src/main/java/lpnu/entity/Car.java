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

    @Override
    public double CalculatePrice(int timeInRoad, int waitingTime, int mileage) {

        double finalPrice = 0;
        double startSumma = 50;
        final double freeWaitingTime = 3; // 3 minutes free
        final double waitingPrice = 5;
        double waitingSumma = (waitingTime - freeWaitingTime) * waitingPrice;
        double timePrice = 5;
        double timeSumma = timeInRoad * timePrice;
        double mileagePrice = 6;
        double mileageSumma = mileage * mileagePrice;

        finalPrice = (startSumma+waitingSumma+Math.max(timeSumma,mileageSumma))*
                ((carStatus == CarStatus.PREMIUM)?1.2:1);
        return finalPrice;
    }
}
