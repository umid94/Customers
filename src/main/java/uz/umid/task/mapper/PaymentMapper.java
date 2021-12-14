package uz.umid.task.mapper;

import org.springframework.stereotype.Component;
import uz.umid.task.dto.PaymentDTO;
import uz.umid.task.entity.Payment;

import java.util.ArrayList;
import java.util.List;

@Component
public class PaymentMapper{

    public PaymentDTO map(Payment payment) {
        PaymentDTO paymentDTO = new PaymentDTO();
        paymentDTO.setId(payment.getId());
        paymentDTO.setAmount(payment.getAmount());
        paymentDTO.setTime(payment.getTime());
        paymentDTO.setInvoiceId(payment.getInvoice().getId());
        return paymentDTO;
    }

    public List<PaymentDTO> map(List<Payment> payments) {
        List<PaymentDTO> paymentDTOS = new ArrayList<>();
        for(Payment p : payments){
            PaymentDTO paymentDTO = map(p);
            paymentDTOS.add(paymentDTO);
        }
        return paymentDTOS;
    }
}
