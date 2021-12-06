package lpnu.entity;

import lpnu.repository.DriverRepository;
import org.springframework.stereotype.Component;

@Component
public class Driver {
    private long id;
    private String name;
    private  String surname;
    private int phoneNumber;

    public Driver() {
    }

    public Driver(String name, String surname, int phoneNumber) {
        this.id = DriverRepository.getNewId();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
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
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
