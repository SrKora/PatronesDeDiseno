package org.example;

import java.util.Scanner;

public class UI {
    private final Scanner sc;

    public UI() {
        this.sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
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
    }

    private int leerEnteroRango(String mensaje, int min, int max) {
        int opcion;
        do {
            opcion = sc.nextInt();
            if (opcion < min || opcion > max) {
                System.out.println("Por favor, elige una opción entre " + min + " y " + max);
            }
        } while (opcion < min || opcion > max);
        return opcion;
    }
}
