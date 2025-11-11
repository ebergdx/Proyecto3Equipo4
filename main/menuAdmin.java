package main;

import java.util.Scanner;

import usuarios.Cliente;

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
}
