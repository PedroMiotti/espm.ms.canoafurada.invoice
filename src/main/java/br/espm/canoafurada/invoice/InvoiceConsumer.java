package br.espm.canoafurada.invoice;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InvoiceConsumer {
    @Autowired
    public InvoiceService invoiceService;

    @KafkaListener(topics = "${topic.name.consumer}", groupId = "canoafurada")
    public InvoiceDto consume(ConsumerRecord<String, InvoiceDto> payload){
        var invoice = new InvoiceDto();
        invoice.setIdBooking(payload.value().getIdBooking());
        invoice.setTotal(payload.value().getTotal());

        return invoiceService.createInvoice(invoice);
    }
}
