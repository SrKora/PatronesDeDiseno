package org.example.decorator;

public interface IPedido {
    int getId();
    float getImporte_base();
    float getImporte_total();
    String getHistorial();
    void setHistorial(String historial);
    void confirmarPedido();
    boolean getConfirmar();
}
