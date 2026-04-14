package org.example.decorator;

import org.example.observer.IObserver;
import org.example.observer.ISujeto;

import java.util.ArrayList;
import java.util.List;

public abstract class Pedido implements IPedido, ISujeto {
    int id;
    float importe;
    String historial;
    boolean confirmado;
    ArrayList<IObserver> suscriptores = new ArrayList<>();

    public Pedido(int id, float importe) {
        this.id = id;
        this.importe = importe;
        this.confirmado = false;
    }

    public int getId() {
        return id;
    }

    public float getImporte() {
        return importe;
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
    public void suscribir(IObserver o) {
        suscriptores.add(o);
    }

    @Override
    public void desuscribir(IObserver o) {
        suscriptores.remove(o);
    }

    @Override
    public void notificar(IPedido p) {
        for (IObserver s : suscriptores) {
            s.actualizar(p);
        }
    }
}
