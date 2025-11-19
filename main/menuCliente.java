package main;

import usuarios.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

import recompensas.Recompensa;
import tareas.Habito;

public class menuCliente {
    private static Scanner sc = new Scanner(System.in);
    
    public static void AppCliente(Cliente cliente) {
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
        ArrayList<Recompensa> recompensas = ControlArchivos.cargarRecompensas();
        
        if (recompensas.isEmpty()) {
            System.out.println("No hay recompensas disponibles en la tienda.");
            return;
        }
        
        System.out.println("Tienes: " + cliente.getPuntos() + " puntos.");
        for (Recompensa r : recompensas) {
            System.out.printf("* [%s] %s - Costo: %d puntos\n",
                r.getTipo(), r.getNombre(), r.getCosto());
        }
    }

    public static void canejarPuntos(Cliente cliente) {
        sc.nextLine();
        System.out.println("--- Canjear Recompensas ---");
        
        ArrayList<Recompensa> recompensas = ControlArchivos.cargarRecompensas();
        
        if (recompensas.isEmpty()) {
            System.out.println("No hay recompensas para canjear");
            return;
        }
        
        System.out.println("Tienes actualmente: " + cliente.getPuntos() + " puntos");
        
        for (int i = 0; i < recompensas.size(); i++) {
            Recompensa r = recompensas.get(i);
            System.out.printf("%d) [%s] %s - Costo: %d puntos\n",
                i, r.getTipo(), r.getNombre(), r.getCosto());
        }
        
        System.out.println("Elige el número de la recompensa a canjear (o -1 para salir):");
        int opc = sc.nextInt();
        
        if (opc < 0 || opc >= recompensas.size()) {
            System.out.println("Selección inválida o cancelada");
            return;
        }
        
        Recompensa recompensaElegida = recompensas.get(opc);
        
        if (cliente.getPuntos() >= recompensaElegida.getCosto()) {
            
            recompensaElegida.canjear(cliente);
            
            System.out.println("Has canjeado: " + recompensaElegida.getNombre());
            System.out.println("Puntos restantes: " + cliente.getPuntos());
            
        } else {
            System.out.println("Puntos insuficientes. Te faltan " + 
                (recompensaElegida.getCosto() - cliente.getPuntos()) + " puntos.");
        }
    }
}
