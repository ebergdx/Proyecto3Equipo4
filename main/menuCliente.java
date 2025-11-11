package main;

import usuarios.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

import tareas.Habito;

public class menuCliente {
    private static Scanner sc = new Scanner(System.in);
    
    public static void mostrarCliente(Cliente cliente) {
        System.out.println("\n\t-- Bienvenido a la aplicación --");
        int opc;
        sc.nextLine();

        do {
            System.out.println("\n1)Añadir hábito\n2)Ver hábitos\n3)Completar hábito\n4)Eliminar hábito");
            System.out.println("5)Ver estadísticas\6)Ver puntos\n7)Ver recompensas\n8)Canjear puntos\n0)Cerrar sesión");
            opc = sc.nextInt();
            
            switch(opc) {
                case 1:
                    crearHabito(cliente);
                    break;
                case 2:
                    verHabitos(cliente);
                    break;
                case 3:
                    marcarHabito(cliente);
                    break;
                case 4:
                    eliminarHabito(cliente);
                    break;
                case 5:
                    estadisticas(cliente);
                    break;
                case 6:
                    verPuntos(cliente);
                    break;
                case 7:
                    verRecompensas(cliente);
                    break;
                case 8:
                    canejarPuntos(cliente);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    break;
            }

        } while(opc != 0);
    }

    public static void crearHabito(Cliente cliente) {
        //se planea cambiarlo o agregar otra funcion con los hábitos creados
        //por los administradores
        System.out.println("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Añada una descripción del hábito.");
        String info = sc.nextLine();
        System.out.println("Añada la frecuencia del hábito.");
        String frecuencia = sc.nextLine();
        System.out.println("Ingrese la categoría del hábito.");
        String categoria = sc.nextLine();

        Habito nuevoHabito = new Habito(nombre, info, frecuencia, categoria);
        cliente.addHabito(nuevoHabito);
    }

    public static void verHabitos(Cliente cliente) {
        ArrayList<Habito> listaHabitos = cliente.getHabitos();

        if(listaHabitos.isEmpty()) {
            System.out.println("No tienes hábitos añadidos.");
            return;
        } else {
            for(int i = 0; i < listaHabitos.size(); i++) {
                System.out.println(listaHabitos.get(i));
            }
        }
    }

    public static void marcarHabito(Cliente cliente) {
        ArrayList<Habito> listaHabitos = cliente.getHabitos();
    
        if(listaHabitos.isEmpty()) {
            System.out.println("No tienes hábitos añadidos.");
            return;
        }
        verHabitos(cliente);
        System.out.println("Seleccione un hábito: ");
        int opc = sc.nextInt();
        listaHabitos.get(opc).diaRacha();
        System.out.println("Hábito completado este día.");
    }

    public static void eliminarHabito(Cliente cliente) {
        ArrayList<Habito> listaHabitos = cliente.getHabitos();
    
        if(listaHabitos.isEmpty()) {
            System.out.println("No tienes hábitos añadidos.");
            return;
        }

        verHabitos(cliente);
        System.out.println("Seleccione un hábito: ");
        int opc = sc.nextInt();
        listaHabitos.remove(opc);
        System.out.println("Hábito eliminado.");
    }

    public static void estadisticas(Cliente cliente) {
        //Se añadirá la lógica respecto al uso de 
        //archivos/registros de clientes y sus hábitos
    }

    public static void verPuntos(Cliente cliente) {
        System.out.print("Esta es su cantidad de puntos: " + cliente.getPuntos());
    }

    public static void verRecompensas(Cliente cliente) {
        //Se mostrarán las recompensas disponibles
    }

    public static void canejarPuntos(Cliente cliente) {
        //Se enlazará la lógica de las recompensas y la información de los archivos
    }
}
