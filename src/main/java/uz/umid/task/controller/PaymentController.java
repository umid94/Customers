package uz.umid.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.umid.task.dto.PaymentDTO;
import uz.umid.task.service.PaymentService;

import java.util.Map;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v.1")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @GetMapping("/payment/details")
    public ResponseEntity<PaymentDTO> getPaymentDetailsById(@RequestParam(name = "paymentId") Long id) {
        return new ResponseEntity<>(paymentService.getPaymentDetailsById(id), OK);
    }

    @PostMapping("/payment")
    public ResponseEntity<Map<String, PaymentDTO>> makePayment(@Param("paymentId") Long id) {
        return new ResponseEntity<>(paymentService.makePayment(id), OK);
    }
}
