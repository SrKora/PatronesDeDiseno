package org.example.decorator;

public class PedidoDescuentoDecorator extends Pedido {

    protected IPedido pedidoEnvuelto;

    public PedidoDescuentoDecorator(IPedido pedidoEnvuelto, float descuento) {
        super(pedidoEnvuelto.getId(), pedidoEnvuelto.getImporte_base());
        this.pedidoEnvuelto = pedidoEnvuelto;
        aplicarDescuento(descuento);
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

    public void aplicarDescuento(float descuento) {
        importe_total = importe_base /  ((descuento/100) + 1);

        historial += "\nSe ha aplicado un descuento del " + descuento + " - Importe Total: " + importe_total;
    }
}