package org.example.decorator;

public class PedidoBase extends Pedido{

    public PedidoBase(int id, float importe) {
        super(id, importe);
        this.historial = "Pedido creado - Id: " + id + "\n El importe base es de " + importe;

    }

    @Override
    public int getId() {
        return super.getId();
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
    public float getImporte() {
        return this.importe;
    }

    @Override
    public String getHistorial() {
        return this.historial;
    }
}
