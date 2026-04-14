package org.example.decorator;

import org.example.observer.IObserver;

public interface IPedido {
    int getId();
    float getImporte();
    String getHistorial();
    void setHistorial(String historial);
    void confirmarPedido();
    boolean getConfirmar();
    void suscribir(IObserver o);
    void desuscribir(IObserver o);
    void notificar(IPedido p);
}
