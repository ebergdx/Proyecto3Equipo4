package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import recompensas.CreadorBono;
import recompensas.CreadorItem;
import recompensas.CreadorLogro;
import recompensas.CrearRecompensa;
import recompensas.Recompensa;
import tareas.Habito;
import usuarios.Admin;
import usuarios.Cliente;

public class menuAdmin {
    private static Scanner sc = new Scanner(System.in);

    public static void Administrar(Admin admin) {
        System.out.println("\n-- Bienvenido al menú de administración --");
        int opc;

        do {
            try {
                System.out.println(
                        "\n1)Crear Recompensas\n2)Ver Recompensas\n3)Analizar registro de usuarios\n4)Analizar categorias de hábitos");
                System.out.println("5)Ver estadísticas\n6)Crear evento o tarea\n7)Editar recompensas\n0)Cerrar sesión");
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
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
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Excepción: Ingrese un número entero.");
                sc.nextLine();
                opc = -1;
            }
        } while (opc != 0);
    }

    private static void crearRecompensa() {
        sc.nextLine();
        System.out.println("-- Crear Nueva Recompens --");

        System.out.println("Ingrese el nombre de la recompensa (Ej: 'Medalla de Bronce'):");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el costo en puntos (Ej: 100):");
        int costo = sc.nextInt();
        sc.nextLine();

        System.out.println("Ingrese el tipo (logro, item, bono):");
        String tipo = sc.nextLine().toLowerCase();

        CrearRecompensa fabrica = null;

        switch (tipo) {
            case "bono":
                fabrica = new CreadorBono();
                break;
            case "item":
                fabrica = new CreadorItem();
                break;
            case "logro":
                fabrica = new CreadorLogro();
                break;
            default:
                System.out.println("Esa recompensa no existe :(");
                return;
        }

        Recompensa nueva = fabrica.crear(nombre, costo);

        ArrayList<Recompensa> recompensas = ControlArchivos.cargarRecompensas();
        recompensas.add(nueva);
        ControlArchivos.guardarRecompensas(recompensas);

        System.out.println("Recompensa creada exitosamente.");
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

    private static void editarRecompensas() {
        System.out.println("\n--- Editar Recompensas ---");
        ArrayList<Recompensa> recompensas = ControlArchivos.cargarRecompensas();

        if (recompensas.isEmpty()) {
            System.out.println("No hay recompensas para editar");
            return;
        }

        for (int i = 0; i < recompensas.size(); i++) {
            Recompensa r = recompensas.get(i);
            System.out.printf("%d) [%s] %s - %d pts\n",
                    i, r.getTipo(), r.getNombre(), r.getCosto());
        }

        System.out.print("\nEliminar recompensa (-1 para cancelar): ");
        int opc = sc.nextInt();
        sc.nextLine();

        if (opc >= 0 && opc < recompensas.size()) {
            recompensas.remove(opc);
            ControlArchivos.guardarRecompensas(recompensas);
            System.out.println("Recompensa eliminada");
        }
    }

    private static void registroUsuarios() {
        System.out.println("\n--- Registro de Usuarios ---");
        ArrayList<Cliente> clientes = Sistema.clientes;
        ArrayList<Admin> admins = Sistema.admins;

        System.out.println("Total usuarios: " + (clientes.size() + admins.size()));
        System.out.println("Clientes: " + clientes.size());
        System.out.println("Admins: " + admins.size());

        System.out.println("\nClientes:");
        for (Cliente c : clientes) {
            System.out.printf("- %s (%s) - %d hábitos, %d pts\n",
                    c.getNombre(), c.getEmail(), c.getHabitos().size(), c.getPuntos());
        }
    }

    private static void categoriasHabitos() {
        System.out.println("\n--- Análisis de Categorías ---");
        ArrayList<Cliente> clientes = Sistema.clientes;

        Map<String, Integer> categorias = new HashMap<>();

        for (Cliente c : clientes) {
            for (Habito h : c.getHabitos()) {
                String cat = h.getCategoria();
                categorias.put(cat, categorias.getOrDefault(cat, 0) + 1);
            }
        }

        if (categorias.isEmpty()) {
            System.out.println("No hay hábitos registrados");
            return;
        }

        System.out.println("Categorías más usadas:");
        for (Map.Entry<String, Integer> entry : categorias.entrySet()) {
            System.out.println("- " + entry.getKey() + ": " + entry.getValue() + " hábitos");
        }
    }

    private static void estadisticasUsuarios() {
        System.out.println("\n-- Estadísticas --");
        ArrayList<Cliente> clientes = Sistema.clientes;

        int totalHabitos = 0;
        int totalPuntos = 0;
        int totalRachas = 0;

        for (Cliente c : clientes) {
            totalHabitos += c.getHabitos().size();
            totalPuntos += c.getPuntos();

            for (Habito h : c.getHabitos()) {
                totalRachas += h.getRacha();
            }
        }

        System.out.println("Total de hábitos: " + totalHabitos);
        System.out.println("Total de puntos: " + totalPuntos);
        System.out.println("Total de rachas: " + totalRachas + " días");

        if (clientes.size() > 0) {
            System.out.println("Promedio hábitos/usuario: " + (totalHabitos / clientes.size()));
        }
    }

    private static void crearTarea() {
        System.out.println("\n--- Crear Tarea ---");
    }
}