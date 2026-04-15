package org.example.observer;

import org.example.decorator.IPedido;

import java.util.ArrayList;

public class Repository {

    protected Cliente[] clientes;

    protected ArrayList<IPedido> pedidos;

    public Repository() {
        this.clientes = new Cliente[] {
                new Cliente("Alex"),
                new Cliente("Maria"),
                new Cliente("Gio"),
                new Cliente("Max")
        };

        this.pedidos = new ArrayList<>();
    }
}
