package org.example.decorator;

public class PedidoImpuestoDecorator extends Pedido{

    protected Pedido pedidoEnvuelto;

    public PedidoImpuestoDecorator(Pedido pedidoEnvuelto) {
        super(pedidoEnvuelto.getId(), pedidoEnvuelto.getImporte_base());
        this.pedidoEnvuelto = pedidoEnvuelto;
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

    public void anadirImpuesto(float impuesto) {
        importe_total = importe_base * ((impuesto/100) + 1);

        historial += "\nSe ha aplicado un impuesto del " + impuesto + " - Importe Total: " + importe_total;
    }
}
