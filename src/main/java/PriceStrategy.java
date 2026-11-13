package com.example;

// Поведенческий паттерн Strategy (Стратегия)
// 1. Интерфейс стратегии
public interface PriceStrategy {
    double calculate(double basePrice);
}

// 2. Конкретные стратегии
class StandardPrice implements PriceStrategy {
    public double calculate(double basePrice) { return basePrice; }
}

class UrgentPrice implements PriceStrategy {
    public double calculate(double basePrice) { return basePrice * 1.5; }
}

class DiscountPrice implements PriceStrategy {
    public double calculate(double basePrice) { return basePrice * 0.9; }
}

// 3. Контекст
class PriceCalculator {
    private PriceStrategy strategy;
    public void setStrategy(PriceStrategy strategy) { this.strategy = strategy; }
    public double calculatePrice(double basePrice) { return strategy.calculate(basePrice); }
}