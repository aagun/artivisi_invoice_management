# Aplikasi Invoice Management

Aplikasi ini dipakai untuk mengelola invoice dan menyambungkan dengan berbagain metode pembayaran.
Diantara metode pembayaran yang akan disupport antara lain:

* Virtual Account
  * Bank BNI
  * Bank CIMB
  * BSI
  

* e-Wallet
  * GoPay
  * Dana
  * OVO


* QR Payment
  * QRIS

# Cara Setup DataBase                                                                         
1. Jalankan PostgreSQL di Docker                                                              
    ```                                                                                       
    docker run --rm \
      --name artivisi-invoice-mangement-db \
      -e POSTGRES_DB=artivisi_invoice_management_db \
      -e POSTGRES_USER=artivisi \
      -e POSTGRES_PASSWORD=z3sB9Kqy3gohmOdubgqp \
      -e PGDATA=/var/lib/postgresql/data/pgdata \
      -v "$PWD/artivisi-invoice-management-data:/var/lib/postgresql/data" \
      -p 5432:5432 \
      postgres:15                                                                             
    ```      
