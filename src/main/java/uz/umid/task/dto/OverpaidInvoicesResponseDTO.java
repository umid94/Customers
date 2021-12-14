package uz.umid.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
public class OverpaidInvoicesResponseDTO {
    Long id;
    BigDecimal differenceAmount;
}
