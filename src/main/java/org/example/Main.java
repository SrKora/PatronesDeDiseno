package org.example;

import org.example.decorator.*;
import org.example.observer.Cliente;
import org.example.observer.IObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static void main() {

        Scanner sc = new Scanner(System.in);

        boolean salir = true;
        int porcentaje, index;
        String nombre;

        Cliente[] clientes = new Cliente[] {
                new Cliente("Alex"),
                new Cliente("Maria"),
                new Cliente("Gio"),
                new Cliente("Max")
        };

        ArrayList<IPedido> pedidos = new ArrayList<>();
        IPedido pedidoActual = new PedidoBase(0, 0);

        System.out.println("Bienvenido al sistema que hace cosas");

        while (salir){
            switch (mostrarOpcionesPedidos(sc)) {
                case 1:
                    crearPedido(sc, pedidos, getRandomClient(clientes));
                    break;
                case 2:
                    mostrarListaPedidos(pedidos);
                    break;
                case 3:
                    pedidoActual = getPedidoPorID(sc, pedidos, pedidoActual);
                    while (salir) {
                        switch (mostrarOpcionesPedidoIndividual(sc)){
                            case 1:
                                System.out.println(pedidoActual);
                                break;
                            case 2:
                                pedidoActual.confirmarPedido();
                                System.out.println("Pedido confirmado");
                                salir = false;
                                break;
                            case 3:
                                pedidos.remove(pedidoActual);
                                System.out.println("Pedido Eliminaod");
                                salir = false;
                                break;
                            case 4:
                                System.out.println("Indique el nombre del cliente que quiere añadir");
                                suscribirCliente(sc, clientes, pedidoActual);
                                break;
                            case 5:
                                System.out.println("Indique el nombre del cliente que quiere eliminar");
                                desuscribirCliente(sc, clientes, pedidoActual);
                                break;
                            case 6:
                                pedidoActual = asignarDescuento(sc, pedidos, pedidoActual);
                                break;
                            case 7:
                                pedidoActual = asignarImpuesto(sc, pedidos, pedidoActual);
                                break;
                            case 8:
                                pedidoActual = asignarGatoEnvio(sc, pedidos, pedidoActual);
                                break;
                            case 9:
                                pedidoActual = asignarRecargo(sc, pedidos, pedidoActual);
                                break;
                            default:
                                salir = false;
                                break;
                        }
                    }
                    salir = true;
                    break;
                case 4:
                    pedidoActual = getPedidoPorID(sc, pedidos, pedidoActual);
                    if (!pedidoActual.getConfirmar()) {
                        pedidoActual.confirmarPedido();
                    } else {
                        System.out.println("Este pedido ya está confirmado!!");
                    }
                    break;
                case 5:
                    pedidoActual = getPedidoPorID(sc, pedidos, pedidoActual);
                    pedidos.remove(pedidoActual);
                    break;
                default:
                    salir = false;
                    break;
            }
        }

    }

    private static IPedido asignarRecargo(Scanner sc, ArrayList<IPedido> pedidos, IPedido pedidoActual) {
        int index;
        int porcentaje;
        System.out.println("Introduzca el recargo que quiere añadirle al pedido:");
        porcentaje = sc.nextInt();
        index = pedidos.indexOf(pedidoActual);
        pedidos.remove(index);
        pedidoActual = new PedidoRecargoDecorator(pedidoActual, porcentaje);
        pedidos.add(index, pedidoActual);
        return pedidoActual;
    }

    private static IPedido asignarGatoEnvio(Scanner sc, ArrayList<IPedido> pedidos, IPedido pedidoActual) {
        int porcentaje;
        int index;
        System.out.println("Introduzca los gastos de envío al pedido:");
        porcentaje = sc.nextInt();
        index = pedidos.indexOf(pedidoActual);
        pedidos.remove(index);
        pedidoActual = new PedidoGastoEnvioDecorator(pedidoActual, porcentaje);
        pedidos.add(index, pedidoActual);
        return pedidoActual;
    }

    private static IPedido asignarImpuesto(Scanner sc, ArrayList<IPedido> pedidos, IPedido pedidoActual) {
        int index;
        int porcentaje;
        System.out.println("Introduzca el impuesto que quiere asignarle al pedido:");
        porcentaje = sc.nextInt();
        index = pedidos.indexOf(pedidoActual);
        pedidos.remove(index);
        pedidoActual = new PedidoImpuestoDecorator(pedidoActual, porcentaje);
        pedidos.add(index, pedidoActual);
        return pedidoActual;
    }

    private static IPedido asignarDescuento(Scanner sc, ArrayList<IPedido> pedidos, IPedido pedidoActual) {
        int porcentaje;
        int index;
        System.out.println("Introduce el descuento que quiere asignar al pedido:");
        porcentaje = sc.nextInt();
        index = pedidos.indexOf(pedidoActual);
        pedidos.remove(index);
        pedidoActual = new PedidoDescuentoDecorator(pedidoActual, porcentaje);
        pedidos.add(index, pedidoActual);
        return pedidoActual;
    }

    private static void desuscribirCliente(Scanner sc, Cliente[] clientes, IPedido pedidoActual) {
        String nombre = sc.next();
        IObserver io = Arrays.stream(clientes).filter(c -> c.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
        pedidoActual.desuscribir(io);
    }

    private static void suscribirCliente(Scanner sc, Cliente[] clientes, IPedido pedidoActual) {
        String nombre = sc.next();
        IObserver io = Arrays.stream(clientes).filter(c -> c.getNombre().equalsIgnoreCase(nombre)).findFirst().orElse(null);
        pedidoActual.suscribir(io);
    }

    private static Cliente getRandomClient(Cliente[] c){
        int i =(int) (Math.random() * c.length);
        return c[i];
    }

    private static IPedido getPedidoPorID(Scanner sc, ArrayList<IPedido> pedidos, IPedido pedidoActual) {
        int id;
        System.out.println("Introduzca el id del pedido que quiere modificar:");
        id = sc.nextInt();
        for (IPedido p : pedidos) {
            if (p.getId() == id) {
               return p;
            } else {
                System.out.println("El id introducido no se corresponde a ningún pedido sin confirmar");
            }
        }
        return pedidoActual;
    }

    private static int mostrarOpcionesPedidoIndividual(Scanner sc) {
        int opcion;
        do {
            System.out.println("Porfavor introduzca la acción que quiera realizar");
            System.out.println("""
        1. Revisar pedido
        2. Confirmar pedido
        3. Eliminar
        4. Añadir cliente
        5. Eliminar cliente
        6. Añadir descuento
        7. Añadir impuesto
        8. Añadir gastos de envío
        9. Añaidr recargo
        10. Salir del pedido
        """);
            opcion = sc.nextInt();
        }while (!(opcion >= 1 && opcion <= 10));
        return opcion;
    }

    private static void mostrarListaPedidos(ArrayList<IPedido> pedidos) {
        for (IPedido p : pedidos) {
            System.out.println("Id: " + p.getId() +
                    " - Precio: " + p.getImporte() +
                    " - Estado: " + ((p.getConfirmar()) ? "Confirmado" : "Por confirmar"));
        }
    }

    private static void crearPedido(Scanner sc, ArrayList<IPedido> pedidos, Cliente c) {
        IPedido pedidoActual;
        int precio, id = 1;
        System.out.println("Introduzca el precio base del pedido");
        precio = sc.nextInt();
        if (pedidos.isEmpty()){
           id = 1;
        } else {
            id = pedidos.getLast().getId() + 1;
        }
        pedidoActual = new PedidoBase(id, precio);
        pedidos.add(pedidoActual);
        pedidoActual.suscribir(c);
    }

    private static int mostrarOpcionesPedidos(Scanner sc) {
        int opcion;
        do {
            System.out.println("Porfavor introduzca la acción que quiera realizar");
            System.out.println("""
                1. Crear pedido
                2. Revisar pedidos
                3. Modificar pedido
                4. Confirmar pedido
                5. Eliminar pedido
                6. Salir
                """);
            opcion = sc.nextInt();
        }while (!(opcion >= 1 && opcion <= 6));
        return opcion;
    }
}