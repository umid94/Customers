package uz.umid.task.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class WrongDateInvoicesResponseDTO {
    Long invoiceId;
    Date issued;
    Long orderId;
    Date orderDate;
}
