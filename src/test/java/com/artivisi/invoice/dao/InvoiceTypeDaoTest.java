package com.artivisi.invoice.dao;

import com.artivisi.invoice.entity.InvoiceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

@SpringBootTest
@Sql(scripts = {"/sql/delete-invoice-type.sql", "/sql/insert-invoice-type.sql"})
public class InvoiceTypeDaoTest {

    @Autowired
    InvoiceTypeDao invoiceTypeDao;

    @Test
    public void insertInvoiceType() throws Exception {
        InvoiceType it = new InvoiceType();
        it.setCode("IT-001");
        it.setName("Invoice Type Test Insert");

        Assertions.assertNull(it.getId());

        invoiceTypeDao.save(it);

        System.out.println(it.toString());
        Assertions.assertNotNull(it.getId());
        Assertions.assertNotNull(it.getCreatedAt());
        Assertions.assertNotNull(it.getCreatedBy());
        Assertions.assertNotNull(it.getUpdatedAt());
        Assertions.assertNotNull(it.getUpdatedBy());

        Thread.sleep(1000);

        it.setName("Invoice Type Test Update");
        it = invoiceTypeDao.save(it);

        System.out.println(it.toString());
        Assertions.assertNotEquals(it.getCreatedAt(), it.getUpdatedAt());

    }

    @Test
    public void querySoftDelete() {
        Long totalRecord = invoiceTypeDao.count();
        Assertions.assertEquals(1, totalRecord);
    }

    @Test
    public void softDelete() {
        InvoiceType it = invoiceTypeDao.findById("ce4295af-8b45-4732-9962-3cd2eb8ed900").get();
        invoiceTypeDao.delete(it);

        Long totalRecord = invoiceTypeDao.count();
        Assertions.assertEquals(0, totalRecord);
    }

}
