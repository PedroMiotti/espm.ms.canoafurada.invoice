package br.espm.canoafurada.invoice;

import br.espm.canoafurada.invoice.interfaces.IInvoiceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InvoiceController implements IInvoiceController {

    @Autowired
    public InvoiceService invoiceService;

    @Override
    public List<InvoiceDto> getAllBookings() {
        return invoiceService.getAllInvoices();
    }

    @Override
    public InvoiceDto createInvoice(InvoiceDto invoice) {
        return invoiceService.createInvoice(invoice);
    }
}
