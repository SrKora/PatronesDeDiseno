package org.example;

import org.example.decorator.*;
import org.example.observer.Service;

public class Main {

    static void main() {

        Service service = new Service();
        UI ui = new UI(service);

        Pedido pedidoActual;

        boolean salir = true;

        System.out.println("Bienvenido al sistema que hace cosas");

        while (salir){
            switch (ui.mostrarMenu()) {
                case 1:
                    service.crearPedido();
                    break;
                case 2:
                    ui.mostrarListaPedidos();
                    break;
                case 3:
                    pedidoActual = service.getPedidoPorID("Introduzca el id del pedido que quiere modificar:");
                    while (salir) {
                        switch (ui.mostrarMenuDePedido()){
                            case 1:
                                System.out.println(pedidoActual);
                                break;
                            case 2:
                                service.confirmarPedido(pedidoActual);
                                salir = false;
                                break;
                            case 3:
                                service.eliminarPedido(pedidoActual);
                                System.out.println("Pedido Eliminado");
                                salir = false;
                                break;
                            case 4:
                                service.suscribirCliente(pedidoActual);
                                break;
                            case 5:
                                service.desuscribirCliente(pedidoActual);
                                break;
                            case 6:
                                pedidoActual = service.asignarDescuento(pedidoActual);
                                break;
                            case 7:
                                pedidoActual = service.asignarImpuesto(pedidoActual);
                                break;
                            case 8:
                                pedidoActual = service.asignarGatoEnvio(pedidoActual);
                                break;
                            case 9:
                                pedidoActual = service.asignarRecargo(pedidoActual);
                                break;
                            default:
                                salir = false;
                                break;
                        }
                    }
                    salir = true;
                    break;
                case 4:
                    pedidoActual = service.getPedidoPorID("Introduzca el id del pedido que quiere confirmar:");
                    service.confirmarPedido(pedidoActual);
                    break;
                case 5:
                    pedidoActual = service.getPedidoPorID("Introduzca el número dle pedido que quiere eliminar");
                    service.eliminarPedido(pedidoActual);
                    System.out.println("Pedido Eliminado");
                    break;
                default:
                    salir = false;
                    break;
            }
        }

    }
}