package com.example;

// Поведенческий паттерн Command (Команда)
// 1. Интерфейс команды
public interface OrderCommand {
    void execute();
    void undo();
}

// 2. Получатель (Receiver)
class KitchenReceiver {
    public void cookCake() { System.out.println("Повар начал готовить торт..."); }
    public void cancelCooking() { System.out.println("Готовка отменена, продукты возвращены."); }
}

// 3. Конкретная команда
class MakeCakeCommand implements OrderCommand {
    private KitchenReceiver kitchen;
    public MakeCakeCommand(KitchenReceiver kitchen) { this.kitchen = kitchen; }
    public void execute() { kitchen.cookCake(); }
    public void undo() { kitchen.cancelCooking(); }
}

// 4. Инициатор (Invoker)
class Waiter {
    private OrderCommand command;
    public void setCommand(OrderCommand command) { this.command = command; }
    public void takeOrder() { command.execute(); }
    public void cancelOrder() { command.undo(); }
}