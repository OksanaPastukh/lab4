package lpnu.dto;

import org.springframework.stereotype.Component;

@Component
public class CompletedStatusDTO {
    private long id;
    private int timeInRoad;
    private int waitingTime;
    private int mileage;

    public CompletedStatusDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTimeInRoad() {
        return timeInRoad;
    }

    public void setTimeInRoad(int timeInRoad) {
        this.timeInRoad = timeInRoad;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }
}
