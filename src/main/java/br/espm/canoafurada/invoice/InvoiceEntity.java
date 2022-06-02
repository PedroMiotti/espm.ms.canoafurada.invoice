package br.espm.canoafurada.invoice;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity(name = "invoice")
public class InvoiceEntity {

    public InvoiceEntity(){}

    public InvoiceEntity(InvoiceDto invoice){
        this.idBooking = invoice.getIdBooking();
        this.createdAt = invoice.getCreatedAt();
        this.total = invoice.getTotal();
    }

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "char(36)")
    @Type(type = "org.hibernate.type.UUIDCharType")
    private UUID id;

    @Column(name = "id_booking", nullable = false, columnDefinition = "char(36)")
    private String idBooking;

    @Column(name = "created_at", nullable = false)
    private Date createdAt;

    @Column(name = "total", nullable = false)
    private double total;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @PrePersist
    protected void onCreate() {
        createdAt = new Date();
    }


    public InvoiceDto toDto(){
        var invoice = new InvoiceDto();
        invoice.setId(id);
        invoice.setIdBooking(idBooking);
        invoice.setCreatedAt(createdAt);
        invoice.setTotal(total);

        return invoice;
    }


}
