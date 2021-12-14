package uz.umid.task.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.umid.task.dto.*;
import uz.umid.task.mapper.InvoiceMapper;
import uz.umid.task.repository.InvoiceRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;
    @Autowired
    private InvoiceMapper invoiceMapper;

    public List<InvoiceDTO> expiredInvoices() {
        List<InvoiceDTO> invoiceDTOs = invoiceMapper.map(invoiceRepository.expiredInvoices());
        return invoiceDTOs;
    }

    public List<WrongDateInvoicesResponseDTO> wrongDateInvoices() {
        List<WrongDateInvoicesResponseDTO>  invoiceDTOs = invoiceRepository.wrongDateInvoices();
        return invoiceDTOs;
    }

    public List<OverpaidInvoicesResponseDTO> overpaidInvoices() {
        List<Object[]> result = invoiceRepository.getOverpaidInvoices();
        List<OverpaidInvoicesResponseDTO> responseDTOs = new ArrayList<>();
        for(Object[] o: result){
            OverpaidInvoicesResponseDTO dto = new OverpaidInvoicesResponseDTO((Long)o[0], (BigDecimal)o[1]);
            responseDTOs.add(dto);
        }
        return responseDTOs;
    }
}
