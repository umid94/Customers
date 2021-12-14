package uz.umid.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import uz.umid.task.entity.Invoice;
import uz.umid.task.entity.Order;

import java.util.Date;

@Data
@NoArgsConstructor
public class OrderDTO {
    private Long id;
    private Date date;
    private Long customerId;
    private Invoice invoice;
}
