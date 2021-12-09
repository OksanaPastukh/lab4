package lpnu.entity;

import lpnu.entity.enumeration.DriverStatus;
import lpnu.exception.ServiceException;
import lpnu.repository.CustomerRepository;
import lpnu.repository.DriverRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Driver implements Serializable {
    private long id;
    private String name;
    private  String surname;
    private int phoneNumber;
    private DriverStatus driverStatus;

    public Driver() {
    }

    public Driver(String name, String surname, int phoneNumber) {
        this.id = DriverRepository.getNewId();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.driverStatus = DriverStatus.ACTIVE;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        if(DriverRepository.isPhoneNumberUnique(id,phoneNumber)){
            this.phoneNumber = phoneNumber ;
        }
        else{
            throw new ServiceException(400,"Customer phone number is not unique");
        }
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", driverStatus=" + driverStatus +
                '}';
    }
}
