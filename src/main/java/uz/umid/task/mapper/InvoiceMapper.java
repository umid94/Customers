package uz.umid.task.mapper;

import org.springframework.stereotype.Component;
import uz.umid.task.dto.InvoiceDTO;
import uz.umid.task.entity.Invoice;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceMapper {

    public InvoiceDTO map(Invoice invoice) {
        InvoiceDTO invoiceDTO = new InvoiceDTO();
        invoiceDTO.setId(invoice.getId());
        invoiceDTO.setOrderId(invoice.getOrders().getId());
        invoiceDTO.setAmount(invoice.getAmount());
        invoiceDTO.setIssued(invoice.getIssued());
        invoiceDTO.setDue(invoice.getDue());
        return invoiceDTO;
    }

    public List<InvoiceDTO> map(List<Invoice> invoices) {
        List<InvoiceDTO> invoiceDTOs = new ArrayList<>();
        for (Invoice i : invoices) {
            InvoiceDTO invoiceDTO = map(i);
            invoiceDTOs.add(invoiceDTO);
        }
        return invoiceDTOs;
    }
}
