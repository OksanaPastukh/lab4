package lpnu.entity;

import lpnu.entity.enumeration.CarStatus;
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
    public double CalculatePrice(int timeInRoad, int waitingTime, int mileage) {
        double finalPrice = 0;
        double startSumma = 100;
        final double freeWaitingTime = 30; // 30 minutes free
        final double waitingPrice = 10;
        double waitingSumma = (waitingTime - freeWaitingTime) * waitingPrice;
        double timePrice = 50;
        double timeSumma = timeInRoad * timePrice;
        double mileagePrice = 55;
        double mileageSumma = mileage * mileagePrice;

        finalPrice = (startSumma+waitingSumma+Math.max(timeSumma,mileageSumma))*
                ((liftingСapacity > 5)?1.2:1);
        return finalPrice;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString() +
                "liftingСapacity=" + liftingСapacity +
                '}';
    }
}
