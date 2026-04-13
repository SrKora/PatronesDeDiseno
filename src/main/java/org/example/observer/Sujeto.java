package org.example.observer;

import org.example.decorator.Pedido;

import java.util.ArrayList;
import java.util.List;

public class Sujeto implements ISujeto{


    List<Observer> subscribers;

    public Sujeto() {
        this.subscribers = new ArrayList<>();
    }

    @Override
    public void subscribe(Observer o) {
        subscribers.add(o);
    }

    @Override
    public void desubscribe(Observer o) {
        subscribers.remove(o);
    }

    @Override
    public void notify(Pedido p) {
        for (Observer o : subscribers) {
            o.update(p);
        }
    }
}
