package org.example.decorator;

import org.example.AnsiColors;

public class PedidoImpuestoDecorator extends Pedido{

    protected IPedido pedidoEnvuelto;
    float impuesto;

    public PedidoImpuestoDecorator(IPedido pedidoEnvuelto, float impuesto) {
        super(pedidoEnvuelto.getId(), pedidoEnvuelto.getImporte());
        this.pedidoEnvuelto = pedidoEnvuelto;
        this.impuesto = impuesto;
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
        return pedidoEnvuelto.toString() + "\nSe ha aplicado un " + AnsiColors.RED + "impuesto del " + impuesto + AnsiColors.RESET + " - Importe Total: " + getImporte();
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
        return pedidoEnvuelto.getImporte() * ((impuesto/100)+1);
    }

    @Override
    public String getHistorial() {
        return pedidoEnvuelto.getHistorial();
    }
}
