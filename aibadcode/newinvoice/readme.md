src/main/java
└─ aibadcode/newinvoice
   ├─ model/Invoice.java
   ├─ port/InvoiceRepository.java
   │        InvoiceCache.java
   │        MailService.java
   │        TokenService.java
   ├─ adapter/jdbc/JdbcInvoiceRepository.java
   ├─ adapter/caching/CaffeineInvoiceCache.java
   ├─ adapter/mail/JavaMailService.java
   ├─ adapter/security/JwtTokenService.java
   ├─ service/InvoiceService.java
   ├─ util/DataSourceFactory.java
   │      JavaMailSessionFactory.java
   │      KeyLoader.java
   └─ Main.java
