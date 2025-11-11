package main;

import java.util.Scanner;

public class Sistema {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("- Bienvenido a la aplicación para registrar hábitos -");
        int opc;

        do {
            System.out.println("1)Iniciar sesión\n2)Crear cuenta\n0)Salir");
            opc = sc.nextInt();

            switch(opc) {
                case 1 -> iniciarSesion();
                case 2 -> crearCuenta();
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Ingrese una opción válida");
            }

        } while(opc != 0);

        private void iniciarSesion() {
            System.out.println("Nombre: ");
            String usuario = sc.nextLine();
            System.out.println("Contraseña: ");
            

        }
    }
}