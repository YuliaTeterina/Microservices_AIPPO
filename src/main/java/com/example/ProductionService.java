package com.example;

// Микросервис: Производство и Доставка
public class ProductionService {
    public void startProduction(String orderId) {
        System.out.println("[ProductionService] Заказ " + orderId + " принят на кухню.");
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        System.out.println("[ProductionService] Заказ " + orderId + " готов!");
    }

    public void arrangeDelivery(String orderId, String address) {
        System.out.println("[ProductionService] Организована доставка заказа " + orderId + " по адресу: " + address);
    }
}