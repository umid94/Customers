package uz.umid.task.service;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.umid.task.dto.DetailDTO;
import uz.umid.task.dto.OrderDTO;
import uz.umid.task.dto.OrdersWithoutInvoicesResponseDTO;
import uz.umid.task.entity.*;
import uz.umid.task.mapper.DetailMapper;
import uz.umid.task.mapper.OrderMapper;
import uz.umid.task.repository.CustomerRepository;
import uz.umid.task.repository.OrderRepository;
import uz.umid.task.repository.ProductRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private DetailMapper detailMapper;

    @SneakyThrows
    public List<OrderDTO> ordersWithoutDetails() {
        String st = "2016/09/06";
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(st);
        List<OrderDTO> orderDTOs = orderMapper.map(orderRepository.ordersWithoutDetails(date));
        return orderDTOs;
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public List<OrdersWithoutInvoicesResponseDTO> ordersWithoutInvoices() {
        List<OrdersWithoutInvoicesResponseDTO> responseDTOList = orderRepository.ordersWithoutInvoices();
        return responseDTOList;
    }

    public DetailDTO getOrderDetailsById(Long id) {
        DetailDTO detailDTO = detailMapper.map(orderRepository.getOrderDetailsById(id));
        return detailDTO;
    }

    @Transactional
    public Map<String, Long> makeOrder(Long customerId, Long productId, int quantity) {
        Detail detail = new Detail();
        Product product = productRepository.getById(productId);
        detail.setProduct(product);
        detail.setQuantity(quantity);
        Invoice invoice = new Invoice();
        invoice.setAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        invoice.setIssued(new Date());
        invoice.setDue(new Date());
        Order order = new Order();
        Customer customer = customerRepository.getById(customerId);
        order.setCustomer(customer);
        order.setDate(new Date());
        order.setDetails((List<Detail>) detail);
        order.setInvoice(invoice);
        save(order);
        Map<String, Long> result = new HashMap<>();
        if (invoice.getId() != null) {
            result.put("Succes", invoice.getId());
        } else {
            result.put("Failed", Long.valueOf(0));
        }
        return result;
    }
}
