package uz.umid.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.umid.task.dto.PaymentDTO;
import uz.umid.task.entity.Invoice;
import uz.umid.task.entity.Payment;
import uz.umid.task.mapper.PaymentMapper;
import uz.umid.task.repository.InvoiceRepository;
import uz.umid.task.repository.PaymentRepository;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private PaymentMapper paymentMapper;
    @Autowired
    private InvoiceRepository invoiceRepository;

    public PaymentDTO getPaymentDetailsById(Long id) {
        PaymentDTO paymentDTO = paymentMapper.map(paymentRepository.getById(id));
        return paymentDTO;
    }

    public Map<String, PaymentDTO> makePayment(Long id) {
        Invoice invoice = invoiceRepository.getById(id);
        Payment payment = new Payment();
        payment.setAmount(invoice.getAmount());
        payment.setTime(new Date());
        payment.setInvoice(invoice);
        invoiceRepository.save(invoice);
        PaymentDTO paymentDTO = (PaymentDTO) paymentMapper.map(invoice.getPayments());
        Map<String, PaymentDTO> stringPaymentDTOMap = new HashMap<>();
        if(paymentDTO != null){
            stringPaymentDTOMap.put("Succes", paymentDTO);
        }else {
            stringPaymentDTOMap.put("Failed", null);
        }
        return stringPaymentDTOMap;
    }
}
