package com.artivisi.invoice.dao;

import com.artivisi.invoice.entity.VirtualAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirtualAcountDao
        extends JpaRepository<VirtualAccount, String> {
}
