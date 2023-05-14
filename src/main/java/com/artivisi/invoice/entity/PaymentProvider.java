package com.artivisi.invoice.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Setter
@Getter
@ToString
@SQLDelete(sql = "UPDATE payment_provider SET status_record = 'INACTIVE' WHERE id=?")
@Where(clause = "status_record = 'ACTIVE'")
public class PaymentProvider extends BaseEntity {

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String code;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 100)
    private String name;

    private String logo;

}
