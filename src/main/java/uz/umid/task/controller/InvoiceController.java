package uz.umid.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.umid.task.dto.InvoiceDTO;
import uz.umid.task.dto.OverpaidInvoicesResponseDTO;
import uz.umid.task.dto.WrongDateInvoicesResponseDTO;
import uz.umid.task.service.InvoiceService;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v.1")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/expired-invoices")
    public ResponseEntity<List<InvoiceDTO>> expiredInvoices() {
        return new ResponseEntity<>(invoiceService.expiredInvoices(), OK);
    }

    @GetMapping("/wrong-date-invoices")
    public ResponseEntity<List<WrongDateInvoicesResponseDTO>> wrongDateInvoices() {
        return new ResponseEntity<>(invoiceService.wrongDateInvoices(), OK);
    }

    @GetMapping("/overpaid-invoices")
    public ResponseEntity<List<OverpaidInvoicesResponseDTO>> overpaidInvoices() {
        return new ResponseEntity<>(invoiceService.overpaidInvoices(), OK);
    }

}
