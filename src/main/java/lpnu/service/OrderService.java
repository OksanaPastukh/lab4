package lpnu.service;

import lpnu.dto.CompletedStatusDTO;
import lpnu.dto.NewOrderDTO;
import lpnu.dto.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(NewOrderDTO newOrderDTO);
    List<OrderDTO> getAllOrders();
    OrderDTO getOrderById(long id);
    OrderDTO appointedOrder(long id_order, long id_vehicle);
    OrderDTO completedOrder(CompletedStatusDTO completedStatusDTO);
    OrderDTO deleteOrderById(long id);
}
