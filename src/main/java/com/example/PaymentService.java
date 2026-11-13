package com.example;

// Микросервис: Оплата
public class PaymentService {
    public boolean processPayment(String method, double amount) {
        System.out.println("[PaymentService] Запрос на оплату " + amount + " руб.");
        try {
            PaymentProcessor processor = PaymentFactory.getProcessor(method); // Использование паттерна Factory
            processor.processPayment(amount);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("[PaymentService] Ошибка: " + e.getMessage());
            return false;
        }
    }
}