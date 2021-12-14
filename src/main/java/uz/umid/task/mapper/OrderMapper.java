package uz.umid.task.mapper;

import org.springframework.stereotype.Component;
import uz.umid.task.dto.OrderDTO;
import uz.umid.task.entity.Order;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    public OrderDTO map(Order order) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(order.getId());
        orderDTO.setDate(order.getDate());
        orderDTO.setCustomerId(order.getCustomer().getId());
        return orderDTO;
    }

    public List<OrderDTO> map(List<Order> orders) {
        List<OrderDTO> orderDTOS = new ArrayList<>();
        for(Order o: orders){
            OrderDTO orderDTO = map(o);
            orderDTOS.add(orderDTO);
        }
        return orderDTOS;
    }
}
