package lpnu.entity;

import lpnu.entity.enumeration.VehicleStatus;
import lpnu.repository.DriverRepository;
import lpnu.repository.VehicleRepository;
import org.springframework.stereotype.Component;


public abstract class Vehicle {
    private long id;
    private String numberVehicle;
    private VehicleStatus vehicleStatus;
    private Driver driver;
    private long driverId;

    protected Vehicle() {
    }

    public Vehicle(String numberVehicle) {
        this.id = VehicleRepository.getNewId();
        this.numberVehicle = numberVehicle;
        this.vehicleStatus = VehicleStatus.NOT_READY;
    }

    public long getId() {
        return id;
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

    public Driver getDriver() {
        if(driverId>0 && driver==null)
        {
            driver = DriverRepository.getDriverById(driverId);
        }
        return driver;
    }

    public void setDriver(Driver driver) {
        if (getVehicleStatus() == VehicleStatus.NOT_READY) {
            this.driver = driver;
            driverId = (driver == null) ? 0 : driver.getId();//not ready
        }
    }

    public void setVehicleStatus(VehicleStatus vehicleStatus) {
        switch (vehicleStatus){
            case NOT_READY:
            case BUSY:
                if(getVehicleStatus() == VehicleStatus.READY)
                {
                    this.vehicleStatus = vehicleStatus;
                }
                break;
            case READY:
                if(getDriver() != null)
                {
                    this.vehicleStatus = vehicleStatus;
                }
                break;
//
//                if(getVehicleStatus() == VehicleStatus.READY)
//                {
//                    this.vehicleStatus = vehicleStatus;
//                }
//                break;
            //exception

        }
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", numberVehicle='" + numberVehicle + '\'' +
                ", vehicleStatus=" + vehicleStatus +
                ", driver=" + driver +
                ", driverId=" + driverId +
                '}';
    }
}
