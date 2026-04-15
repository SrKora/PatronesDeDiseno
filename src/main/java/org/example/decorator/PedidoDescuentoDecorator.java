package org.example.decorator;

public class PedidoDescuentoDecorator extends Pedido {

    protected IPedido pedidoEnvuelto;
    float descuento;

    public PedidoDescuentoDecorator(IPedido pedidoEnvuelto, float descuento) {
        super(pedidoEnvuelto.getId(), pedidoEnvuelto.getImporte());
        this.pedidoEnvuelto = pedidoEnvuelto;
        this.descuento = descuento;
    }

    @Override
    public int getId() {
        return pedidoEnvuelto.getId();
    }

    @Override
    public void setHistorial(String historial) {
        pedidoEnvuelto.setHistorial(historial);
    }

    @Override
    public String toString() {
        return pedidoEnvuelto.toString() + "\nSe ha aplicado un descuento del " + descuento + " - Importe Total: " + getImporte();
    }

    @Override
    public boolean getConfirmar() {
        return pedidoEnvuelto.getConfirmar();
    }

    @Override
    public void confirmarPedido() {
        pedidoEnvuelto.confirmarPedido();
    }

    @Override
    public float getImporte() {
        return pedidoEnvuelto.getImporte() / ((descuento/100)+1);
    }

    @Override
    public String getHistorial() {
        return pedidoEnvuelto.getHistorial();
    }
}