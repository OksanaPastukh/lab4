package lpnu.resourse;


import lpnu.dto.*;
import lpnu.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @PostMapping("/orders")
    public OrderDTO createOrder(@RequestBody @Validated final NewOrderDTO newOrderDTO){
        return orderService.createOrder(newOrderDTO);
    }
    @GetMapping("/orders")
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/orders/{id}")
    public OrderDTO getOrderById(@PathVariable final long id) {
        return orderService.getOrderById(id);
    }

    @PutMapping("/orders/appointed/{id_order}/{id_vehicle}")
    public OrderDTO appointedOrder(@PathVariable final long id_order,@PathVariable final long id_vehicle){
        return orderService.appointedOrder(id_order,id_vehicle);
    }
    @PutMapping("/orders/completed")
    public OrderDTO completedOrder(@RequestBody @Validated final CompletedStatusDTO completedStatusDTO){
        return orderService.completedOrder(completedStatusDTO);
    }
    @DeleteMapping("/orders/{id}")
    public OrderDTO deleteOrderById(@PathVariable final  long id){
        return orderService.deleteOrderById(id);
    }
}
