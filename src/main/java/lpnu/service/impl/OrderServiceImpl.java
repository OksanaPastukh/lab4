package lpnu.service.impl;

import lpnu.dto.CompletedStatusDTO;
import lpnu.dto.NewOrderDTO;
import lpnu.dto.OrderDTO;
import lpnu.entity.Driver;
import lpnu.entity.Order;
import lpnu.entity.Vehicle;
import lpnu.mapper.CustomerToCustomerDTOMapper;
import lpnu.mapper.DriverToDriverDTOMapper;
import lpnu.mapper.OrderToOrderDTOMapper;
import lpnu.repository.CustomerRepository;
import lpnu.repository.DriverRepository;
import lpnu.repository.OrderRepository;
import lpnu.repository.VehicleRepository;
import lpnu.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderDTO createOrder(NewOrderDTO newOrderDTO) {
        Order order = OrderRepository.createOrder(newOrderDTO);
        return OrderToOrderDTOMapper.toDTO(order);
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return OrderRepository.getAllOrders().stream()
                .map(e -> OrderToOrderDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(long id) {
        return OrderToOrderDTOMapper.toDTO(OrderRepository.getOrderById(id));
    }

    @Override
    public OrderDTO appointedOrder(long id_order, long id_vehicle) {
        Order order = OrderRepository.getOrderById(id_order);
        Vehicle vehicle = VehicleRepository.getVehicleById(id_vehicle);
        order.appointedStatus(vehicle);
        return OrderToOrderDTOMapper.toDTO(order);
    }

    @Override
    public OrderDTO completedOrder(CompletedStatusDTO completedStatusDTO) {
        Order order = OrderRepository.getOrderById(completedStatusDTO.getId());
        order.completedStatus(completedStatusDTO.getTimeInRoad(),
                completedStatusDTO.getWaitingTime(),completedStatusDTO.getMileage());
        return OrderToOrderDTOMapper.toDTO(order);
    }

    @Override
    public OrderDTO deleteOrderById(long id) {
        Order order = OrderRepository.getOrderById(id);
        order.canceledStatus();
        return OrderToOrderDTOMapper.toDTO(order);
    }
}
