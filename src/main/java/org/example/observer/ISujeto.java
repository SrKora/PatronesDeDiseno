package org.example.observer;

import org.example.decorator.Pedido;

public interface ISujeto {
    void subscribe(Observer o);
    void desubscribe(Observer o);
    void notify(Pedido p);
}
