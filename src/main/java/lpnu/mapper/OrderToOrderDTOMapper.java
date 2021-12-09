package lpnu.mapper;

import lpnu.dto.OrderDTO;
import lpnu.entity.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderToOrderDTOMapper {

    public static OrderDTO toDTO(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setOrderStatus(order.getOrderStatus());
        orderDTO.setVehicleType(order.getVehicleType());
        orderDTO.setTimeInRoad(order.getTimeInRoad());
        orderDTO.setWaitingTime(order.getWaitingTime());
        orderDTO.setMileage(order.getMileage());
        orderDTO.setPrice(order.getPrice());
        orderDTO.setAddressTo(order.getAddressTo());
        orderDTO.setAddressFrom(order.getAddressFrom());

        orderDTO.setDriverId((order.getDriver())==null?0:order.getDriver().getId());
        orderDTO.setCustomerId((order.getCustomer())==null?0:order.getCustomer().getId());
        orderDTO.setVehicleId((order.getVehicle())==null?0:order.getVehicle().getId());

        orderDTO.setDriverName((order.getDriver())==null?"":
                order.getDriver().getSurname()+" "+order.getDriver().getName());
        orderDTO.setCustomerName((order.getCustomer())==null?"":
                order.getCustomer().getSurname()+" "+order.getCustomer().getName());
        orderDTO.setVehicleNumber((order.getVehicle())==null?"":order.getVehicle().getNumberVehicle());

        return orderDTO;
    }
}
