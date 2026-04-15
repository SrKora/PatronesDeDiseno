package org.example.observer;

import org.example.decorator.IPedido;

public class Cliente implements IObserver{
    private final String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void actualizar(IPedido p) {
        System.out.println("Buenos días " + nombre + " ha recibido un pedido\n" + p.toString());
    }

    @Override
    public String toString() {
        return getNombre();
    }
}