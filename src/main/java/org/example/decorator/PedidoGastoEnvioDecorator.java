package org.example.decorator;

public class PedidoGastoEnvioDecorator extends Pedido {

    protected IPedido pedidoEnvuelto;
    float gasto;

    public PedidoGastoEnvioDecorator(IPedido pedidoEnvuelto, float gastoEnvio) {
        super(pedidoEnvuelto.getId(), pedidoEnvuelto.getImporte());
        this.pedidoEnvuelto = pedidoEnvuelto;
        this.gasto = gasto;
    }

    @Override
    public int getId() {
        return pedidoEnvuelto.getId();
    }

    @Override
    public float getImporte() {
        return pedidoEnvuelto.getImporte() + gasto;
    }

    @Override
    public void setHistorial(String historial) {
        pedidoEnvuelto.setHistorial(historial);
    }

    @Override
    public String toString() {
        return pedidoEnvuelto.toString() + "\nSe ha aplicado un gasto de " + gasto + " - Importe Total: " + getImporte();
    }

    @Override
    public String getHistorial() {
        return pedidoEnvuelto.getHistorial();
    }

}
