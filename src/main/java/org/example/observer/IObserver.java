package org.example.observer;

import org.example.decorator.Pedido;

public interface IObserver {
    void update(Pedido p);
}
