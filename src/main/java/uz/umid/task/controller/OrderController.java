package uz.umid.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.umid.task.dto.DetailDTO;
import uz.umid.task.dto.OrderDTO;
import uz.umid.task.dto.OrdersWithoutInvoicesResponseDTO;
import uz.umid.task.service.OrderService;

import java.util.List;
import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v.1")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/order-without-details")
    public ResponseEntity<List<OrderDTO>> ordersWithoutDetails() {
        return new ResponseEntity<>(orderService.ordersWithoutDetails(), OK);
    }

    @GetMapping("/order-without-invoices")
    public ResponseEntity<List<OrdersWithoutInvoicesResponseDTO>> ordersWithoutInvoices() {
        return new ResponseEntity<>(orderService.ordersWithoutInvoices(), OK);
    }

    @GetMapping("order/details")
    public ResponseEntity<DetailDTO> getOrderDetailsById(@RequestParam(name = "orderId") Long id) {
        return new ResponseEntity<>(orderService.getOrderDetailsById(id), OK);
    }

    @PostMapping("/order")
    public ResponseEntity<Map<String, Long>> makeOrder(@Param("customerId") Long customerId, @Param("productId") Long productId, @Param("quantity") int quantity) {
        return new ResponseEntity<>(orderService.makeOrder(customerId, productId, quantity), OK);
    }
}
