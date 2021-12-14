package uz.umid.task.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.umid.task.dto.InvoiceDTO;
import uz.umid.task.dto.OverpaidInvoicesResponseDTO;
import uz.umid.task.dto.WrongDateInvoicesResponseDTO;
import uz.umid.task.entity.Invoice;

import java.util.List;

@Repository
public interface InvoiceRepository extends CrudRepository<Invoice, Long> {

    @Query(value = "SELECT i FROM Invoice i WHERE i.due < i.issued")
    List<Invoice> expiredInvoices();

    @Query(value = "SELECT i.id AS invoiceId, i.issued AS issued, o.id AS orderId, o.date AS orderDate FROM Invoice i JOIN Order o ON o.id=i.orders.id  WHERE i.issued < o.date")
    List<WrongDateInvoicesResponseDTO> wrongDateInvoices();

    @Query(value = "SELECT i.id, SUM(p.amount) - i.amount FROM Invoice  i JOIN Payment p ON i.id=p.invoice.id GROUP BY i.id HAVING SUM(p.amount) - i.amount > 0")
    List<Object[]> getOverpaidInvoices();

    Invoice getById(Long id);
}
