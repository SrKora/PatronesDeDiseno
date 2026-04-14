package org.example.decorator;

import java.util.ArrayList;
import java.util.List;

public abstract class Pedido implements IPedido {
    int id;
    float importe;
    String historial;
    boolean confirmado;

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
}
