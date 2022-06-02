package br.espm.canoafurada.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public InvoiceDto createInvoice(InvoiceDto invoice){
        invoiceRepository.save(new InvoiceEntity(invoice));

        return invoice;
    }

    public List<InvoiceDto> getAllInvoices(){
        return StreamSupport
                .stream(invoiceRepository.findAll().spliterator(), false)
                .collect(Collectors.toList())
                .stream().map(InvoiceEntity::toDto)
                .collect(Collectors.toList());
    }

}
