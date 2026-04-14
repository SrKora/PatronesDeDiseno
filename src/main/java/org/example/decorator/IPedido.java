package org.example.decorator;

public interface IPedido {
    int getId();
    float getImporte();
    String getHistorial();
    void setHistorial(String historial);
    void confirmarPedido();
    boolean getConfirmar();
}
