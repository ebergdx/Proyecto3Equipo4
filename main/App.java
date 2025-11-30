package main;

import java.util.InputMismatchException;
import java.util.Scanner;
import eventos.GestorEventos;
import eventos.ObservadorLogros;
import eventos.ObservadorEstadisticas;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Sistema.inicializar();
        configurarSistemaEventos();

        System.out.println("-- Bienvenido a la Agenda Antiprocrastinación --");
        int opc;

        do {
            try {
                System.out.println("\n1)Iniciar sesión\n2)Crear cuenta\n3)Salir");
                System.out.print("-Ingrese su opción: ");
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1 -> Sistema.iniciarSesion();
                    case 2 -> Sistema.crearCuenta();
                    case 3 -> System.out.println("Gracias por su preferencia");
                    default -> System.out.println("Ingrese una opción válida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Excepción: Ingrese un número entero");
                sc.nextLine();
                opc = 9;
            }
        } while (opc != 3);

        Sistema.finalizar();
        sc.close();
    }

    private static void configurarSistemaEventos() {
        GestorEventos gestor = GestorEventos.getInstancia();
        gestor.agregarObservador(new ObservadorLogros());
        gestor.agregarObservador(new ObservadorEstadisticas());
        
        System.out.println("Sistema de eventos configurado");
    }
    
}
