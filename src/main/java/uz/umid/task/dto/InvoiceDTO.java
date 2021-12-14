package uz.umid.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import uz.umid.task.entity.Invoice;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class InvoiceDTO {

    private Long id;
    private Long orderId;
    private BigDecimal amount;
    private Date issued;
    private Date due;
    private List<PaymentDTO> paymentDTOS;
    private Date orderDate;
    private BigDecimal differenceAmount;
}
