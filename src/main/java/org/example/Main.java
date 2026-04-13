package org.example;

import org.example.decorator.IPedido;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static void main() {

        Scanner sc = new Scanner(System.in);

        boolean salir = true;
        int opcion;

        ArrayList<IPedido> pedidos = new ArrayList<>();

        System.out.println("Bienvenido al sistema que hace cosas");

        while (salir) {
            do {
                System.out.println("Porfavor introduzca la acción que quiera realizar");
                System.out.println("""
                    1. Crear pedido
                    2. Revisar pedidos
                    3. Modificar pedido
                    4. Confirmar pedido
                    """);
                opcion = sc.nextInt();
            }while (!(opcion >= 1 && opcion <= 4));
        }
    }
}
