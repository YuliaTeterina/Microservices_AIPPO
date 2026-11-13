package com.example;

// Порождающий паттерн Singleton (Одиночка)
public class DatabaseConnection {

    private static DatabaseConnection instance;
    private String connectionStatus;

    private DatabaseConnection() {
        this.connectionStatus = "Подключено к БД каталога";
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public String getConnectionStatus() { return connectionStatus; }
}