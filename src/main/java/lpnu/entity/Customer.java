package lpnu.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lpnu.entity.enumeration.CustomerStatus;
import lpnu.exception.ServiceException;
import lpnu.repository.CustomerRepository;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Customer implements Serializable {
    private long id;
    private String name;
    private  String surname;
    private int phoneNumber;
    private CustomerStatus customerStatus;

    private Customer() {
    }

    public Customer(String name, String surname, int phoneNumber) {
        this.id = CustomerRepository.getNewId();
        this.name = name;
        this.surname = surname;
        this.setPhoneNumber(phoneNumber);
        this.customerStatus = CustomerStatus.ACTIVE;
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
        if(CustomerRepository.isPhoneNumberUnique(id,phoneNumber)){
            this.phoneNumber = phoneNumber ;
        }
        else{
            throw new ServiceException(400,"Customer phone number is not unique");
        }
    }

    public CustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(CustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
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

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", customerStatus=" + customerStatus +
                '}';
    }
}
