package org.example.decorator;

import org.example.observer.IObserver;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Pedido implements IPedido {
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
        notificar(this);
    }

    public String nombreSuscriptores() {
        return Arrays.toString(suscriptores.toArray());
    }

    @Override
    public String toString() {
        return nombreSuscriptores() + "\n" + historial;
    }

    @Override
    public void suscribir(IObserver o) {
        if (!suscriptores.contains(o)){
            suscriptores.add(o);
        } else {
            System.out.println("Este cliente ya ha sido añadido");
        }
    }

    @Override
    public void desuscribir(IObserver o) {
        if (suscriptores.toArray().length != 1){
            suscriptores.remove(o);
        } else {
            System.out.println("No puedes dejar un pedido sin clientes");
        }
    }

    @Override
    public void notificar(IPedido p) {
        for (IObserver s : suscriptores) {
            s.actualizar(p);
        }
    }
}
