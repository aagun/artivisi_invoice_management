package com.artivisi.invoice.dao;

import com.artivisi.invoice.entity.InvoiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceTypeDao
        extends JpaRepository<InvoiceType, String> {
}
