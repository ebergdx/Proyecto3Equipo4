package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("- Bienvenido a la aplicación para registrar hábitos -");
        int opc;

        do {
            try {
                System.out.println("1)Iniciar sesión\n2)Crear cuenta\n0)Salir");
                opc = sc.nextInt();
                sc.nextLine();

                switch(opc) {
                    case 1 -> Sistema.iniciarSesion();
                    case 2 -> Sistema.crearCuenta();
                    case 3 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Ingrese una opción válida");
                }
            } catch(InputMismatchException e) {
                System.out.println("Excepción: Ingrese un número entero.");
                sc.nextLine();
                e.printStackTrace();
                opc = 9;
            }
        } while(opc != 0);
    }
}
