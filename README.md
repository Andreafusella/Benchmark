📊 API Endpoint

🔹 Benchmark completo

Esegue INSERT, SELECT, UPDATE, DELETE in sequenza e stampa i tempi nel terminale.

📂 src/main/java/com/bigDataPostgre/bigDataPostgres
├── 📂 controller
│   ├── AccountController.java    # Endpoint REST
├── 📂 service
│   ├── AccountService.java       # Logica per benchmark
├── 📂 repository
│   ├── AccountRepository.java    # Interfaccia JPA
├── 📂 model
│   ├── Account.java              # Entità del database
└── 📜 application.properties      # Configurazione database

Esegue INSERT, SELECT, UPDATE, DELETE in sequenza e stampa i tempi nel terminale.

Postgres:
POST http://localhost:8080/api/postgre/benchmark?count=[count]

MySql:
POST http://localhost:8080/api/mysql/benchmark?count=[count]

📌 Parametro:
	•	count: numero di record su cui eseguire le operazioni

📌 Risultato:
	•	I tempi di esecuzione vengono stampati nel terminale

Esempio di output in console:
Benchmark per 1000 operazioni:
INSERT: 0.14567 sec
SELECT: 0.02345 sec
UPDATE: 0.13456 sec
DELETE: 0.09876 sec