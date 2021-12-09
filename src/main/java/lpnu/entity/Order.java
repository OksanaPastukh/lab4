package lpnu.entity;

import lpnu.entity.enumeration.OrderStatus;
import lpnu.entity.enumeration.VehicleStatus;
import lpnu.entity.enumeration.VehicleType;
import lpnu.exception.ServiceException;
import lpnu.repository.CustomerRepository;
import lpnu.repository.DriverRepository;
import lpnu.repository.OrderRepository;
import lpnu.repository.VehicleRepository;
import org.apache.maven.artifact.versioning.OverConstrainedVersionException;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Order implements Serializable {
    private long id;
    private OrderStatus orderStatus;
    private VehicleType vehicleType;
    private int timeInRoad;
    private int waitingTime;
    private int mileage;
    private double price;

    private String addressTo;
    private String addressFrom;

    private long driverId ;
    private long customerId ;
    private long vehicleId ;
    private transient Driver driver;
    private transient Customer customer;
    private transient Vehicle vehicle;

    public Order() {
    }

    public Order(Customer customer,VehicleType vehicleType,String addressTo, String addressFrom) {
        this.id = OrderRepository.getNewId();
        this.setCustomer(customer);
        this.vehicleType = vehicleType;
        this.addressTo = addressTo;
        this.addressFrom = addressFrom;
        this.orderStatus = OrderStatus.BOOKING;
    }
    public long getId() {
        return id;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public int getTimeInRoad() {
        return timeInRoad;
    }

    private void setTimeInRoad(int timeInRoad) {
        this.timeInRoad = timeInRoad;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    private void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getMileage() {
        return mileage;
    }

    private void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Driver getDriver() {
        if(driverId>0 && driver==null)
        {
            driver = DriverRepository.getDriverById(driverId);
        }
        return driver;
    }

    public Customer getCustomer() {
        if(customerId>0 && customer==null){
            customer = CustomerRepository.getCustomerById(customerId);
        }
        return customer;
    }

    private void setCustomer(Customer customer) {
        this.customer = customer;
        this.customerId = customer.getId();
    }

    private void setDriver(Driver driver) {
        this.driver = driver;
        this.driverId = driver.getId();
    }

    private void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.vehicleId = vehicle.getId();
    }

    public Vehicle getVehicle() {
        if(vehicleId>0 && vehicle==null)
        {
            vehicle = VehicleRepository.getVehicleById(vehicleId);
        }
        return vehicle;
    }

    private void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void appointedStatus(Vehicle vehicle){
        if (getOrderStatus() != OrderStatus.BOOKING )
        {
            throw new ServiceException(400,"Order status is not BOOKING");
        }
         if(vehicle.getVehicleStatus() != VehicleStatus.READY)
         {
             throw new ServiceException(400,"Vehicle status is not READY");
         }
            this.setVehicle(vehicle);
            this.setDriver(vehicle.getDriver());

            vehicle.setVehicleStatus(VehicleStatus.BUSY);
            setOrderStatus(OrderStatus.APPOINTED);

    }
    public void completedStatus(int timeInRoad,int waitingTime,int mileage){
        if(getOrderStatus()!= OrderStatus.APPOINTED)
        {
            throw new ServiceException(400,"Order status is not APPOINTED");
        }
        this.setTimeInRoad(timeInRoad);
        this.setWaitingTime(waitingTime);
        this.setMileage(mileage);
        getVehicle().setVehicleStatus(VehicleStatus.READY);
        setOrderStatus(OrderStatus.COMPLETED);
        setPrice(calcPrice());
    }

    public double calcPrice(){

        return getVehicle().CalculatePrice(timeInRoad,waitingTime,mileage);
    }
    public void canceledStatus(){
        if(getOrderStatus() != OrderStatus.BOOKING){
            throw new ServiceException(400,"Order status is not BOOKING");
        }
        setOrderStatus(OrderStatus.CANCELED);
    }


    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", orderStatus=" + orderStatus +
                ", timeInRoad=" + timeInRoad +
                ", waitingTime=" + waitingTime +
                ", mileage=" + mileage +
                ", addressTo='" + addressTo + '\'' +
                ", addressFrom='" + addressFrom + '\'' +
                ", driverId=" + driverId +
                ", driver=" + driver +
                ", customerId=" + customerId +
                ", customer=" + customer +
                ", vehicleId=" + vehicleId +
                ", vehicle=" + vehicle +
                ", price=" + price +
                '}';
    }

}
