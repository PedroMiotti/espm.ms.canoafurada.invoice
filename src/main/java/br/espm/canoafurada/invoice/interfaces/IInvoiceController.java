package br.espm.canoafurada.invoice.interfaces;

import br.espm.canoafurada.invoice.InvoiceDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public interface IInvoiceController {
    @GetMapping("/invoice")
    public List<InvoiceDto> getAllBookings();

    @PostMapping("/invoice")
    public InvoiceDto createInvoice(InvoiceDto invoice);
}
