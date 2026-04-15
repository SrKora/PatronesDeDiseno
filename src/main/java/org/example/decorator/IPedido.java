package org.example.decorator;

import org.example.observer.IObserver;

import java.util.ArrayList;

public interface IPedido {
    int getId();
    float getImporte();
    String getHistorial();
    ArrayList<IObserver> getSuscriptores();
    public String nombreSuscriptores();
    void setHistorial(String historial);
    void confirmarPedido();
    boolean getConfirmar();

}
