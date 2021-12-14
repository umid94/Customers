package uz.umid.task.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.umid.task.entity.Payment;

import java.util.List;

@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {

    @Query("SELECT p FROM Payment p WHERE p.invoice.id = ?1")
    List<Payment> findByInvoice(Long id);

    Payment getById(Long id);
}
