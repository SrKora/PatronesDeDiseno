package org.example.decorator;

public class PedidoRecargoDecorator extends Pedido{

    protected IPedido pedidoEnvuelto;
    float recargo;

    public PedidoRecargoDecorator(IPedido pedidoEnvuelto, float recargo) {
        super(pedidoEnvuelto.getId(), pedidoEnvuelto.getImporte());
        this.pedidoEnvuelto = pedidoEnvuelto;
        this.recargo = recargo;
    }

    @Override
    public int getId() {
        return pedidoEnvuelto.getId();
    }

    @Override
    public float getImporte() {
        return pedidoEnvuelto.getImporte() + recargo;
    }

    @Override
    public void setHistorial(String historial) {
        pedidoEnvuelto.setHistorial(historial);
    }

    @Override
    public String toString() {
        return pedidoEnvuelto.toString() + "\nSe ha aplicado un recargo de " + recargo + " - Importe Total: " + getImporte();
    }

    @Override
    public String getHistorial() {
        return pedidoEnvuelto.getHistorial();
    }
}
