package org.example.decorator;

public class PedidoRecargoDecorator extends Pedido{

    protected IPedido pedidoEnvuelto;

    public PedidoRecargoDecorator(IPedido pedidoEnvuelto, float recargo) {
        super(pedidoEnvuelto.getId(), pedidoEnvuelto.getImporte_base());
        this.pedidoEnvuelto = pedidoEnvuelto;
        anadirRecargo(recargo);
    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public float getImporte_base() {
        return super.getImporte_base();
    }

    @Override
    public void setHistorial(String historial) {
        super.setHistorial(historial);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public float getImporte_total() {
        return pedidoEnvuelto.getImporte_total();
    }

    @Override
    public String getHistorial() {
        return pedidoEnvuelto.getHistorial();
    }

    public void anadirRecargo(float recargo) {
        importe_total += recargo;

        historial += "\nSe ha aplicado un recargo de " + recargo + " - Importe Total: " + importe_total;
    }
}
