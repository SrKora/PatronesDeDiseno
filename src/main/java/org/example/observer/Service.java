package org.example.observer;

import org.example.UI;
import org.example.decorator.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Service {
    protected Repository repo;

    public Service() {
        this.repo = new Repository();
    }

    public void crearPedido() {
        IPedido pedidoActual;
        int precio, id;
        precio = UI.leerEntero("Introduzca el precio base del pedido");
        if (repo.pedidos.isEmpty()){
            id = 1;
        } else {
            id = repo.pedidos.getLast().getId() + 1;
        }
        pedidoActual = new PedidoBase(id, precio);
        pedidoActual.suscribir(getRandomClient(repo.clientes));
        anadirPedido(pedidoActual);
    }

    public ArrayList<IPedido> listaDePedidos() {
        return repo.pedidos;
    }

    private static Cliente getRandomClient(Cliente[] c){
        int i =(int) (Math.random() * c.length);
        return c[i];
    }

    public IPedido getPedidoPorID(String mensaje) {
        int id;
        id = UI.leerEntero(mensaje);
        for (IPedido p : repo.pedidos) {
            if (p.getId() == id) {
                return p;
            } else {
                System.out.println("El id introducido no se corresponde a ningún pedido sin confirmar");
            }
        }
        return null;
    }

    public IPedido asignarRecargo(IPedido pedidoActual) {
        int index;
        int porcentaje;
        porcentaje = UI.leerEntero("Introduzca el recargo que quiere añadirle al pedido:");
        index = repo.pedidos.indexOf(pedidoActual);
        eliminarPedido(repo.pedidos.get(index));
        pedidoActual = new PedidoRecargoDecorator(pedidoActual, porcentaje);
        anadirPorIndice(index, pedidoActual);
        return pedidoActual;
    }

    public IPedido asignarGatoEnvio(IPedido pedidoActual) {
        int porcentaje;
        int index;
        porcentaje = UI.leerEntero("Introduzca los gastos de envío al pedido:");
        index = repo.pedidos.indexOf(pedidoActual);
        eliminarPedido(repo.pedidos.get(index));
        pedidoActual = new PedidoGastoEnvioDecorator(pedidoActual, porcentaje);
        anadirPorIndice(index, pedidoActual);
        return pedidoActual;
    }

    public IPedido asignarImpuesto(IPedido pedidoActual) {
        int index;
        int porcentaje;
        porcentaje = UI.leerEntero("Introduzca el impuesto que quiere asignarle al pedido:");
        index = repo.pedidos.indexOf(pedidoActual);
        eliminarPedido(repo.pedidos.get(index));
        pedidoActual = new PedidoImpuestoDecorator(pedidoActual, porcentaje);
        anadirPorIndice(index, pedidoActual);
        return pedidoActual;
    }

    public IPedido asignarDescuento(IPedido pedidoActual) {
        int porcentaje;
        int index;
        porcentaje = UI.leerEntero("Introduce el descuento que quiere asignar al pedido:");
        index = repo.pedidos.indexOf(pedidoActual);
        eliminarPedido(repo.pedidos.get(index));
        pedidoActual = new PedidoDescuentoDecorator(pedidoActual, porcentaje);
        anadirPorIndice(index, pedidoActual);
        return pedidoActual;
    }

    public void confirmarPedido(IPedido pedidoActual) {
        if (!pedidoActual.getConfirmar()) {
            pedidoActual.confirmarPedido();
        } else {
            System.out.println("Este pedido ya está confirmado!!");
        }
    }

    public void suscribirCliente(IPedido pedidoActual) {
        Arrays.stream(repo.clientes).forEach(System.out::println);
        System.out.println(Arrays.toString(repo.clientes));
        String nombre = UI.leerTexto("Indique el nombre del cliente que quiere añadir");
        IObserver io = Arrays.stream(repo.clientes).filter(c -> c.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
        pedidoActual.suscribir(io);
    }

    public void desuscribirCliente(IPedido pedidoActual) {
        Arrays.stream(repo.clientes).forEach(System.out::println);
        String nombre = UI.leerTexto("Indique el nombre del cliente que quiere eliminar");
        IObserver io = Arrays.stream(repo.clientes).filter(c -> c.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
        pedidoActual.desuscribir(io);
    }

    public void eliminarPedido(IPedido p) {
        repo.pedidos.remove(p);
    }

    public void anadirPedido(IPedido p) {
        repo.pedidos.add(p);
    }

    public void anadirPorIndice(int index, IPedido p) {
        repo.pedidos.add(index, p);
    }
}
