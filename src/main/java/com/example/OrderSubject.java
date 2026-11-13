package com.example;

import java.util.ArrayList;
import java.util.List;

// Поведенческий паттерн Observer (Наблюдатель)
// 1. Интерфейс подписчика
interface Observer {
    void update(String orderStatus);
}

// 2. Конкретные подписчики
class CustomerObserver implements Observer {
    private String name;
    public CustomerObserver(String name) { this.name = name; }
    public void update(String orderStatus) {
        System.out.println("Клиент " + name + " получил уведомление: Статус - " + orderStatus);
    }
}

class ConfectionerObserver implements Observer {
    public void update(String orderStatus) {
        System.out.println("Кондитер видит: Статус заказа изменился на " + orderStatus);
    }
}

// 3. Издатель (Субъект)
public class OrderSubject {
    private List<Observer> observers = new ArrayList<>();
    private String status;

    public void attach(Observer observer) { observers.add(observer); }
    public void setStatus(String newStatus) {
        this.status = newStatus;
        for (Observer observer : observers) observer.update(status);
    }
}