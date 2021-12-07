package lpnu.dto;

import lpnu.entity.Driver;
import lpnu.entity.enumeration.VehicleStatus;
import org.springframework.stereotype.Component;

@Component
public class VehicleDTO {
    private long id;
    private String numberVehicle;
    private VehicleStatus vehicleStatus;
    private long driverId;
    private String driverName;


    public VehicleDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNumberVehicle() {
        return numberVehicle;
    }

    public void setNumberVehicle(String numberVehicle) {
        this.numberVehicle = numberVehicle;
    }

    public VehicleStatus getVehicleStatus() {
        return vehicleStatus;
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        this.vehicleStatus = vehicleStatus;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
    }

}
