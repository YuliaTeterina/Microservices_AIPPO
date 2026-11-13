package com.example;

// Структурный паттерн Facade (Фасад)
public class OrderFacade {
    private CatalogService catalogService;
    private PaymentService paymentService;
    private ProductionService productionService;

    public OrderFacade() {
        this.catalogService = new CatalogService();
        this.paymentService = new PaymentService();
        this.productionService = new ProductionService();
    }

    // Скрывает сложную цепочку вызовов трех сервисов
    public String processFullOrder(String cakeName, String paymentMethod, String address) {
        System.out.println("[OrderFacade] Начинаем комплексную обработку заказа...");

        if (!catalogService.checkIngredients(cakeName)) return "ОШИБКА: Недостаточно ингредиентов";

        double price = catalogService.getBasePrice(cakeName);
        if (!paymentService.processPayment(paymentMethod, price)) return "ОШИБКА: Оплата не прошла";

        String orderId = "ORD-" + (int)(Math.random() * 1000);
        productionService.startProduction(orderId);
        catalogService.consumeIngredients(cakeName);
        productionService.arrangeDelivery(orderId, address);

        return orderId;
    }
}