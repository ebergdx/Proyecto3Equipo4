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
import tareas.Evento;
import tareas.Habito;
import tareas.Reto;
import usuarios.Admin;
import usuarios.Cliente;

public class menuAdmin {
    private static Scanner sc = new Scanner(System.in);

    public static void Administrar(Admin admin) {
        System.out.println("\n-- Menú de administración --");
        int opc;

        do {
            try {
                System.out.println(
                        "\n1)Crear Recompensas\n2)Ver Recompensas\n3)Analizar registro de usuarios\n4)Analizar categorías de tareas");
                System.out.println("5)Ver estadísticas\n\n6)Editar recompensas\n0)Cerrar sesión");
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
                        categoriasTareas();
                        break;
                    case 5:
                        estadisticasUsuarios();
                        break;
                    case 6:
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
                System.out.println("Excepción: Ingrese un número entero");
                sc.nextLine();
                opc = -1;
            }
        } while (opc != 0);
    }

    private static void crearRecompensa() {
        sc.nextLine();
        System.out.println("-- Crear Recompensas --");

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

        System.out.println("Recompensa creada :)");
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
        System.out.println("\n-- Editar Recompensas --");
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
        System.out.println("\n-- Registro de Usuarios --");
        ArrayList<Cliente> clientes = Sistema.clientes;
        ArrayList<Admin> admins = Sistema.admins;

        System.out.println("Total usuarios: " + (clientes.size() + admins.size()));
        System.out.println("Clientes: " + clientes.size());
        System.out.println("Admins: " + admins.size());

        System.out.println("\nClientes:");
        for (Cliente c : clientes) {
            System.out.printf("- %s (%s) - H:%d E:%d R:%d - %d pts\n",
                    c.getNombre(), c.getEmail(),
                    c.getHabitos().size(), c.getEventos().size(), c.getRetos().size(),
                    c.getPuntos());
        }
    }

    private static void categoriasTareas() {
        System.out.println("\n-- Estadísticas de Tareas --");
        ArrayList<Cliente> clientes = Sistema.clientes;

        Map<String, Integer> categoriasHabitos = new HashMap<>();
        Map<String, Integer> categoriasEventos = new HashMap<>();
        Map<String, Integer> categoriasRetos = new HashMap<>();

        for (Cliente c : clientes) {
            for (Habito h : c.getHabitos()) {
                String cat = h.getCategoria();
                categoriasHabitos.put(cat, categoriasHabitos.getOrDefault(cat, 0) + 1);
            }
            for (Evento e : c.getEventos()) {
                String cat = e.getCategoria();
                categoriasEventos.put(cat, categoriasEventos.getOrDefault(cat, 0) + 1);
            }
            for (Reto r : c.getRetos()) {
                String cat = r.getCategoria();
                categoriasRetos.put(cat, categoriasRetos.getOrDefault(cat, 0) + 1);
            }
        }

        if (categoriasHabitos.isEmpty() && categoriasEventos.isEmpty() && categoriasRetos.isEmpty()) {
            System.out.println("No hay tareas registradas");
            return;
        }

        if (!categoriasHabitos.isEmpty()) {
            System.out.println("\nCategorías de Hábitos:");
            for (Map.Entry<String, Integer> entry : categoriasHabitos.entrySet()) {
                System.out.println("  - " + entry.getKey() + ": " + entry.getValue());
            }
        }

        if (!categoriasEventos.isEmpty()) {
            System.out.println("\nCategorías de Eventos:");
            for (Map.Entry<String, Integer> entry : categoriasEventos.entrySet()) {
                System.out.println("  - " + entry.getKey() + ": " + entry.getValue());
            }
        }

        if (!categoriasRetos.isEmpty()) {
            System.out.println("\nCategorías de Retos:");
            for (Map.Entry<String, Integer> entry : categoriasRetos.entrySet()) {
                System.out.println("  - " + entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private static void estadisticasUsuarios() {
        System.out.println("\n-- Estadísticas Generales --");
        ArrayList<Cliente> clientes = Sistema.clientes;

        int totalHabitos = 0;
        int totalEventos = 0;
        int totalRetos = 0;
        int totalPuntos = 0;
        int totalRachas = 0;
        int eventosTerminados = 0;
        int retosCompletados = 0;

        for (Cliente c : clientes) {
            totalHabitos += c.getHabitos().size();
            totalEventos += c.getEventos().size();
            totalRetos += c.getRetos().size();
            totalPuntos += c.getPuntos();

            for (Habito h : c.getHabitos()) {
                totalRachas += h.getRacha();
            }

            for (Evento e : c.getEventos()) {
                if (e.isTerminado())
                    eventosTerminados++;
            }

            for (Reto r : c.getRetos()) {
                if (r.isCompletado())
                    retosCompletados++;
            }
        }

        System.out.println("\nTareas:");
        System.out.println("  Total de hábitos: " + totalHabitos);
        System.out.println("  Total de eventos: " + totalEventos + " (Terminados: " + eventosTerminados + ")");
        System.out.println("  Total de retos: " + totalRetos + " (Completados: " + retosCompletados + ")");

        System.out.println("\nPuntos y Rachas:");
        System.out.println("  Total de puntos: " + totalPuntos);
        System.out.println("  Total de rachas: " + totalRachas + " días");

        if (clientes.size() > 0) {
            System.out.println("\nPromedios por usuario:");
            System.out.println("  Hábitos: " + (totalHabitos / clientes.size()));
            System.out.println("  Eventos: " + (totalEventos / clientes.size()));
            System.out.println("  Retos: " + (totalRetos / clientes.size()));
            System.out.println("  Puntos: " + (totalPuntos / clientes.size()));
        }
    }

}