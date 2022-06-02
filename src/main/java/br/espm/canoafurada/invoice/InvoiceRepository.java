package br.espm.canoafurada.invoice;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface InvoiceRepository extends CrudRepository<InvoiceEntity, UUID> { }
