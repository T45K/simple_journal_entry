package com.okeicalm.simpleJournalEntry.testutil

import java.sql.DriverManager

fun init() {
    val jdbcUrl =
        "jdbc:mysql://127.0.0.1:3306/simple_journal_entry_db?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true"
    DriverManager.getConnection(jdbcUrl, "mysqluser", "password")
        .use { conn -> // TODO System.getProperty for username and password
            conn.createStatement().use { stmt ->
                stmt.execute("truncate table companies;")
                stmt.execute("insert into companies values (1, 'moneyforward'), (2, 'Rakuten'), (3, 'LINE'), (4, 'freee');")
            }
        }
}
