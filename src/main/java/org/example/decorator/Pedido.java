package org.example.decorator;
public abstract class Pedido implements IPedido {
    int id;
    float importe_base, importe_total;
    String historial;


    public Pedido(int id, float importe_base) {
        this.id = id;
        this.importe_base = importe_base;
        this.importe_total = importe_base;
        this.historial = "Pedido creado\n El importe base es de " + importe_base;
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
    public String toString() {
        return historial;
    }
}
