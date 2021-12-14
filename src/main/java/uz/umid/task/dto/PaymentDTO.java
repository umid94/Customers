package uz.umid.task.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import uz.umid.task.entity.Payment;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private Date time;
    private BigDecimal amount;
    private Long invoiceId;
}
