package lpnu.dto;

import lpnu.entity.enumeration.DriverStatus;
import org.springframework.stereotype.Component;

@Component
public class DriverDTO {
    private long id;
    private String name;
    private  String surname;
    private int phoneNumber;
    private DriverStatus driverStatus;

    public DriverDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
        this.phoneNumber = phoneNumber;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", driverStatus=" + driverStatus +
                '}';
    }
}
