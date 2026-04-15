package org.example.observer;

import org.example.decorator.IPedido;

public interface IPedidoObservable {
    void suscribir(IObserver o);
    void desuscribir(IObserver o);
    void notificar(IPedido p);
}
