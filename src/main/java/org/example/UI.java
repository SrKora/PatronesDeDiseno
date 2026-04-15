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
        System.out.println("1. Revisar pedido\n" +
                AnsiColors.GREEN + "2. Confirmar pedido\n" + AnsiColors.RESET +
                AnsiColors.RED + "3. Eliminar pedido\n" + AnsiColors.RESET +
                "4. Añadir cliente\n" +
                AnsiColors.RED + "5. Eliminar cliente\n" + AnsiColors.RESET +
                "6. Añadir descuento\n" +
                "7. Añadir impuesto\n" +
                "8. Añadir gastos de envío\n" +
                "9. Añaidr recargo\n" +
                "10. Salir del pedido\n");

        return leerEnteroRango(1, 10);
    }

    public int mostrarMenu() {
        System.out.println("Porfavor introduzca la acción que quiera realizar");
        System.out.println(
                "1. Crear pedido\n" +
                "2. Revisar pedidos\n" +
                "3. Modificar pedido\n" +
                AnsiColors.GREEN + "4. Confirmar pedido\n" + AnsiColors.RESET +
                AnsiColors.RED + "5. Eliminar pedido\n" + AnsiColors.RESET +
                "6. Salir"
        );

        return leerEnteroRango(1, 6);
    }

    public static int leerEntero(String mensaje) {
        System.out.println(mensaje);
        while (!sc.hasNextInt()) {
            System.out.println(AnsiColors.RED + "Error" + AnsiColors.RESET + ": Debes introducir un número válido.");
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
                System.out.println("Id: " + p.getId() +
                        " - Precio: " + p.getImporte() +
                        " - Estado: " + ((p.getConfirmar()) ?
                        AnsiColors.GREEN +  "Confirmado" + AnsiColors.RESET :
                        AnsiColors.RED +  "Por confirmar" + AnsiColors.RESET));
            }
        }
    }
}
