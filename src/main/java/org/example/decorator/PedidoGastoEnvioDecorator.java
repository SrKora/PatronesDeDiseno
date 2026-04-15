package org.example.decorator;

import org.example.AnsiColors;

public class PedidoGastoEnvioDecorator extends Pedido {

    protected IPedido pedidoEnvuelto;
    float gasto;

    public PedidoGastoEnvioDecorator(IPedido pedidoEnvuelto, float gastoEnvio) {
        super(pedidoEnvuelto.getId(), pedidoEnvuelto.getImporte());
        this.pedidoEnvuelto = pedidoEnvuelto;
        this.gasto = gastoEnvio;
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
        return pedidoEnvuelto.toString() + "\nSe ha aplicado un " +  AnsiColors.PURPLE + "gasto de " + gasto + AnsiColors.RESET + " - Importe Total: " + getImporte();
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
    public String getHistorial() {
        return pedidoEnvuelto.getHistorial();
    }

}
