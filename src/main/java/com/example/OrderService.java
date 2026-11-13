package com.example;

// Микросервис: Заказы и Клиенты
public class OrderService {
    private OrderFacade orderFacade; // Использование Facade
    private OrderSubject orderSubject; // Использование Observer

    public OrderService() {
        this.orderFacade = new OrderFacade();
        this.orderSubject = new OrderSubject();

        this.orderSubject.attach(new CustomerObserver("Клиент"));
        this.orderSubject.attach(new ConfectionerObserver());
    }

    public void createOrder(String customerName, String cakeName, String paymentMethod, String address) {
        System.out.println("\n--- ОФОРМЛЕНИЕ ЗАКАЗА ---");
        System.out.println("[OrderService] Клиент: " + customerName + ", Товар: " + cakeName);

        // Вызов Фасада
        String result = orderFacade.processFullOrder(cakeName, paymentMethod, address);

        if (result.startsWith("ОШИБКА")) {
            System.out.println("[OrderService] Заказ отклонен: " + result);
        } else {
            // Уведомление подписчиков через Observer
            orderSubject.setStatus("Успешно создан (ID: " + result + ")");
            System.out.println("--- ЗАКАЗ УСПЕШНО ВЫПОЛНЕН ---\n");
        }
    }
}