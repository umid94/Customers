package uz.umid.task.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.umid.task.dto.BulkProductsResponseDTO;
import uz.umid.task.dto.HighDemandProductsResponseIDTO;
import uz.umid.task.entity.Product;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p")
    List<Product> getAllProduct();

    @Query(value = "SELECT p FROM Product p WHERE p.id = ?1")
    Product getById(Long id);

    @Query(value = "SELECT new uz.umid.task.dto.HighDemandProductsResponseIDTO(p.name, d.quantity) FROM Product p INNER JOIN Detail  d ON p.id= d.product.id WHERE d.quantity > 10 ")
    List<HighDemandProductsResponseIDTO> getHighDemandProducts();

    @Query(value = "SELECT new uz.umid.task.dto.BulkProductsResponseDTO(p.name, p.price) FROM Product p JOIN Detail d ON p.id = d.product.id GROUP BY p.id HAVING avg(d.quantity) > 8")
    List<BulkProductsResponseDTO> getBulkProducts();
}
