package uz.umid.task.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.umid.task.dto.OrdersWithoutInvoicesResponseDTO;
import uz.umid.task.entity.Detail;
import uz.umid.task.entity.Order;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {

    @Query(value = "SELECT o FROM Order o LEFT JOIN Detail d ON o.id=d.orders.id WHERE o.date < ?1 AND d.orders.id IS NULL ")
    List<Order> ordersWithoutDetails(Date date);

    @Query(value = "SELECT new uz.umid.task.dto.OrdersWithoutInvoicesResponseDTO(o.id, o.date, sum(d.quantity * p.price)) FROM Order o INNER JOIN Detail d ON o.id= d.orders.id  INNER JOIN Product p ON p.id = d.product.id LEFT JOIN Invoice i  ON o.id = i.orders.id WHERE i.orders.id IS NUll GROUP BY o.id")
    List<OrdersWithoutInvoicesResponseDTO> ordersWithoutInvoices();

    @Query(value = "SELECT d FROM Detail d WHERE d.orders.id = ?1")
    Detail getOrderDetailsById(Long id);
}
