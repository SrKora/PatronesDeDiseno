package org.example.decorator;

public class PedidoGastoEnvioDecorator extends Pedido {

    protected Pedido pedidoEnvuelto;

    public PedidoGastoEnvioDecorator(Pedido pedidoEnvuelto) {
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

    public void anadirGastoEnvio(float gasto) {
        importe_total += gasto;

        historial += "\nSe ha aplicado un gasto de " + gasto + " - Importe Total: " + importe_total;
    }
}
