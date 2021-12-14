package uz.umid.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
public class OrdersWithoutInvoicesResponseDTO {
    Long id;
    Date date;
    Number sum;
}
