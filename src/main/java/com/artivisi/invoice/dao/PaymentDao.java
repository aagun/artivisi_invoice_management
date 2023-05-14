package com.artivisi.invoice.dao;

import com.artivisi.invoice.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDao
        extends JpaRepository<Payment, String> {
}
