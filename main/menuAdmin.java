package main;

import java.util.Scanner;
import java.util.ArrayList;
import usuarios.Admin;
import recompensas.*;

public class menuAdmin {
    private static Scanner sc = new Scanner(System.in);
    
    public static void mostrarCliente(Admin admin) {
        System.out.println("\n\t-- Bienvenido al menú de administración --");
        int opc;
        sc.nextLine();

        do {
            System.out.println("\n1)Crear Recompensas\n2)Ver Recompensas\n3)Analizar registro de usuarios\n4)Analizar categorias de hábitos");
            System.out.println("5)Ver estadísticas\n6)Crear evento o tarea\n7)Editar recompensas\n0)Cerrar sesión");
            opc = sc.nextInt();
            
            switch(opc) {
                case 1:
                    crearRecompensa();
                    break;
                case 2:
                    verRecompensas();
                    break;
                case 3:
                    registroUsuarios();
                    break;
                case 4:
                    categoriasHabitos();
                    break;
                case 5:
                    estadisticasUsuarios();
                    break;
                case 6:
                    crearTarea();
                    break;
                case 7:
                    editarRecompensas();
                    break;
                case 0:
                    System.out.println("Saliendo del sistema");
                    break;
                default:
                    break;
            }

        } while(opc != 0);

        /*Todavía no se ha definido exactamente cómos e implementarán dichos métodos, ya que primero es necesario
         manejar los archivos para tener un mayor panorama */
    }

    private static void crearRecompensa() {
        sc.nextLine(); 
        System.out.println("--- Crear Nueva Recompensa ---");
        
        System.out.println("Ingrese el nombre de la recompensa (Ej: 'Medalla de Bronce'):");
        String nombre = sc.nextLine();
        
        System.out.println("Ingrese el costo en puntos (Ej: 100):");
        int costo = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el tipo (logro, item, bono):");
        String tipo = sc.nextLine();
        
        ArrayList<Recompensa> recompensas = ControlArchivos.cargarRecompensas();
        
        Recompensa nueva = CrearRecompensa.crearRecompensa(tipo, nombre, costo);
        
        recompensas.add(nueva);
        
        ControlArchivos.guardarRecompensas(recompensas);
        
        System.out.println("Recompensa creada");
    }

    private static void verRecompensas() {
        System.out.println("-- Recompensas Disponibles --");
        ArrayList<Recompensa> recompensas = ControlArchivos.cargarRecompensas();
        
        if (recompensas.isEmpty()) {
            System.out.println("No hay recompensas creadas");
            return;
        }
        
        for (int i = 0; i < recompensas.size(); i++) {
            Recompensa r = recompensas.get(i);
            System.out.printf("%d) [%s] %s - Costo: %d puntos\n",
                i, r.getTipo(), r.getNombre(), r.getCosto());
        }
    }
}
