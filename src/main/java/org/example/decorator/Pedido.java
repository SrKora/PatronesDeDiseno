package org.example.decorator;

import org.example.observer.ISujeto;
import org.example.observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements IPedido, ISujeto {
    int id;
    float importe_base, importe_total;
    String historial;
    boolean confirmado;
    List<Observer> subscribers = new ArrayList<>();

    public Pedido(int id, float importe_base) {
        this.id = id;
        this.importe_base = importe_base;
        this.importe_total = importe_base;
        this.historial = "Pedido creado - Id: " + id + "\n El importe base es de " + importe_base;
        this.confirmado = false;
    }

    public int getId() {
        return id;
    }

    public float getImporte_base() {
        return importe_base;
    }

    public float getImporte_total() {
        return importe_total;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }

    @Override
    public boolean getConfirmar() {
        return confirmado;
    }

    @Override
    public void confirmarPedido() {
        this.confirmado = true;
    }

    @Override
    public String toString() {
        return historial;
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
