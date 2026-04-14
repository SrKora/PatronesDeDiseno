package org.example.observer;

import org.example.decorator.IPedido;

public interface IObserver {
    void actualizar(IPedido p);
    String getNombre();
}
