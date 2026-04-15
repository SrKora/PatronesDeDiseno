package org.example;

import org.example.decorator.IPedido;
import org.example.observer.Service;

import java.util.Scanner;

public class UI {
    private static Scanner sc;
    private final Service service;

    public UI(Service cs) {
        this.service = cs;
        this.sc = new Scanner(System.in);
    }

    public int mostrarMenuDePedido() {
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

        return leerEnteroRango(1, 10);
    }

    public int mostrarMenu() {
        System.out.println("Porfavor introduzca la acción que quiera realizar");
        System.out.println("""
            1. Crear pedido
            2. Revisar pedidos
            3. Modificar pedido
            4. Confirmar pedido
            5. Eliminar pedido
            6. Salir
        """);

        return leerEnteroRango(1, 6);
    }

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println("Error: Debes introducir un número válido.");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    public static String leerTexto(String mensaje){
        System.out.println(mensaje);
        return sc.next();
    }
    private int leerEnteroRango(int min, int max) {
        int opcion;
        do {
            opcion = sc.nextInt();
            if (opcion < min || opcion > max) {
                System.out.println("Por favor, elige una opción entre " + min + " y " + max);
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }

    public void mostrarListaPedidos() {
        if (service.listaDePedidos().isEmpty()) {
            System.out.println("No hay pedidos registrados.");
        } else {
            System.out.println("\n--- LISTA DE PEDIDOS ---");
            for (IPedido p : service.listaDePedidos()) {
                System.out.println(p);
            }
        }
    }
}
