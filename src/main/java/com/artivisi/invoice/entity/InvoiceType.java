package com.artivisi.invoice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.util.HashSet;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE invoice_type SET status_record = 'INACTIVE' WHERE id=?")
@Where(clause = "status_record = 'ACTIVE'")
public class InvoiceType extends BaseEntity {

    @NotNull @NotEmpty @Size(min = 3, max = 100)
    private String code;

    @NotNull @NotEmpty @Size(min = 3, max = 100)
    private String name;

    @ManyToMany
    @JoinTable(
            name = "invoice_type_provider",
            joinColumns = @JoinColumn(name = "id_invoice_type"),
            inverseJoinColumns = @JoinColumn(name = "id_payment_provider")
    )
    private Set<PaymentProvider> paymentProviders = new HashSet<>();

}
