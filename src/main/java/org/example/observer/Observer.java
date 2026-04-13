package org.example.observer;

import org.example.decorator.Pedido;

public class Observer implements IObserver{
    String name;

    public Observer(String name) {
        this.name = name;
    }

    @Override
    public void update(Pedido p) {
        System.out.println(name + " has recibido un nuevo correo con un pedido");

    }
}
