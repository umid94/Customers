package uz.umid.task.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.umid.task.dto.CustomerLastOrdersResponseDTO;
import uz.umid.task.dto.NumberOfProductsInYearResponseDTO;
import uz.umid.task.entity.Customer;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    @Query(value = "SELECT c FROM Customer c")
    Customer getById(Long id);

    @Query(value = "SELECT c FROM Customer c JOIN Order o ON c.id=o.customer.id WHERE year(o.date) != ?1 GROUP BY  c.id")
    List<Customer> customersWithoutOrders(int date);

    @Query(value = "SELECT new uz.umid.task.dto.CustomerLastOrdersResponseDTO(c.id , c.name , MAX(o.date)) FROM Customer c JOIN Order o ON c.id = o.customer.id GROUP BY c.id")
    List<CustomerLastOrdersResponseDTO> customerLastOrders();

    @Query(value = "SELECT new uz.umid.task.dto.NumberOfProductsInYearResponseDTO(c.country, COUNT(c.country)) FROM Customer c JOIN Order o ON c.id= o.customer.id WHERE year(o.date) != ?1 GROUP BY c.country")
    List<NumberOfProductsInYearResponseDTO> getSumOrdersInYearByCountry(int date);
}
