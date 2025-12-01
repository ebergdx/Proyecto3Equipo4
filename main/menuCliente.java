package main;

import usuarios.Cliente;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import recompensas.Recompensa;
import tareas.*;
import excepciones.*;

public class menuCliente {
    private static Scanner sc = new Scanner(System.in);

    public static void AppCliente(Cliente cliente) {
        System.out.println("\n-- Bienvenido a la Agenda Antiprocrastinación --");
        int opc;

        do {
            try {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1) Gestionar Hábitos");
                System.out.println("2) Gestionar Eventos");
                System.out.println("3) Gestionar Retos");
                System.out.println("4) Ver estadísticas");
                System.out.println("5) Ver puntos");
                System.out.println("6) Ver recompensas");
                System.out.println("7) Canjear puntos");
                System.out.println("0) Cerrar sesión");
                System.out.print("-Ingrese su opción: ");
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1:
                        menuHabitos(cliente);
                        break;
                    case 2:
                        menuEventos(cliente);
                        break;
                    case 3:
                        menuRetos(cliente);
                        break;
                    case 4:
                        estadisticas(cliente);
                        break;
                    case 5:
                        verPuntos(cliente);
                        break;
                    case 6:
                        verRecompensas(cliente);
                        break;
                    case 7:
                        canjearPuntos(cliente);
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

    public static void menuHabitos(Cliente cliente) {
        int opc;
        do {
            try {
                System.out.println("\n-- Gestionar Hábitos --");
                System.out.println("1) Añadir hábito");
                System.out.println("2) Ver hábitos");
                System.out.println("3) Completar hábito");
                System.out.println("4) Eliminar hábito");
                System.out.println("0) Volver");
                System.out.print("-Ingrese su opción: ");
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
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
                    case 0:
                        System.out.println("Regresando al menú principal");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Excepción: Ingrese un número entero.");
                sc.nextLine();
                opc = -1;
            } catch (ListaEventosVacia e) {
                System.out.println(e.getMessage());
                opc = -1;
            } catch (ListaTareasVacia e) {
                System.out.println(e.getMessage());
                opc = -1;
            } catch (ListaRecompensasVacia e) {
                System.out.println(e.getMessage());
                opc = -1;
            } catch (IndiceNoPermitido e) {
                System.out.println(e.getMessage());
                opc = -1;
            }
        } while (opc != 0);
    }

    public static void menuEventos(Cliente cliente) {
        int opc;
        do {
            try {
                System.out.println("\n-- Gestionar Eventos --");
                System.out.println("1) Añadir evento");
                System.out.println("2) Ver eventos");
                System.out.println("3) Marcar evento como terminado");
                System.out.println("4) Eliminar evento");
                System.out.println("0) Volver");
                System.out.print("-Ingrese su opción: ");
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1:
                        crearEvento(cliente);
                        break;
                    case 2:
                        verEventos(cliente);
                        break;
                    case 3:
                        marcarEvento(cliente);
                        break;
                    case 4:
                        eliminarEvento(cliente);
                        break;
                    case 0:
                        System.out.println("Volviendo al menú prinicpal");
                        break;
                    default:
                        System.out.println("Opción inválida");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Excepción: Ingrese un número entero");
                sc.nextLine();
                opc = -1;
            } catch (ListaEventosVacia e) {
                System.out.println(e.getMessage());
                opc = -1;
            } catch (ListaTareasVacia e) {
                System.out.println(e.getMessage());
                opc = -1;
            } catch (ListaRecompensasVacia e) {
                System.out.println(e.getMessage());
                opc = -1;
            } catch (IndiceNoPermitido e) {
                System.out.println(e.getMessage());
                opc = -1;
            }
        } while (opc != 0);
    }

    public static void menuRetos(Cliente cliente) {
        int opc;
        do {
            try {
                System.out.println("\n-- Gestionar Retos --");
                System.out.println("1) Añadir reto");
                System.out.println("2) Ver retos");
                System.out.println("3) Marcar reto como completado");
                System.out.println("4) Eliminar reto");
                System.out.println("0) Volver");
                System.out.print("-Ingrese su opción: ");
                opc = sc.nextInt();
                sc.nextLine();

                switch (opc) {
                    case 1:
                        crearReto(cliente);
                        break;
                    case 2:
                        verRetos(cliente);
                        break;
                    case 3:
                        marcarReto(cliente);
                        break;
                    case 4:
                        eliminarReto(cliente);
                        break;
                    case 0:
                        System.out.println("Regresando al menú principal");
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

    public static void crearHabito(Cliente cliente) {
        sc.nextLine();
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Añada una descripción del hábito: ");
        String info = sc.nextLine();
        System.out.print("Añada la frecuencia del hábito: ");
        String frecuencia = sc.nextLine();
        System.out.print("Ingrese la categoría del hábito: ");
        String categoria = sc.nextLine();

        FabAbsTareas creador = new FabricaHabito();
        Habito nuevoHabito = (Habito) creador.crearTarea(nombre, info, categoria, frecuencia);
        cliente.addHabito(nuevoHabito);
    }

    public static void verHabitos(Cliente cliente) {
        ArrayList<Habito> listaHabitos = cliente.getHabitos();

        if(listaHabitos.isEmpty()) {
            throw new ListaTareasVacia();
        } else {
            for(int i = 0; i < listaHabitos.size(); i++) {
                System.out.println("[" + i +"]" + listaHabitos.get(i));
            }
        }
    }

    public static void marcarHabito(Cliente cliente) {
        ArrayList<Habito> listaHabitos = cliente.getHabitos();

        if(listaHabitos.isEmpty()) {
            throw new ListaTareasVacia();
        }

        verHabitos(cliente);

        System.out.println("Seleccione un hábito: ");
        int opc = sc.nextInt();
        sc.nextLine();

        if(opc >= 0 && opc < listaHabitos.size()) {
            cliente.completarHabito(opc);
            System.out.println("Hábito completado este día");

        } else {
            throw new IndiceNoPermitido();
        }
    }

    public static void eliminarHabito(Cliente cliente) {
        ArrayList<Habito> listaHabitos = cliente.getHabitos();

        if (listaHabitos.isEmpty()) {
            throw new ListaTareasVacia();
        }

        verHabitos(cliente);
        System.out.println("Seleccione un hábito: ");
        int opc = sc.nextInt();

        if(opc >= 0 && opc < listaHabitos.size()) {
            listaHabitos.remove(opc);
            System.out.println("Hábito eliminado");
        } else {
            throw new IndiceNoPermitido();
        }
    }

    public static void estadisticas(Cliente cliente) {
        System.out.println("\n-- Estadísticas --");

        ArrayList<Habito> habitos = cliente.getHabitos();

        System.out.println("Puntos acumulados: " + cliente.getPuntos());
        System.out.println("Total de hábitos activos: " + habitos.size());
        System.out.println("Logros desbloqueados: " + cliente.getLogros().size());
        System.out.println("Items en inventario: " + cliente.getItems().size());

        if(habitos.isEmpty()) {
            throw new IndiceNoPermitido();
        }
    }

    public static void crearEvento(Cliente cliente) {
        sc.nextLine();
        System.out.print("Ingrese el título del evento: ");
        String titulo = sc.nextLine();
        System.out.print("Añada una descripción del evento: ");
        String info = sc.nextLine();
        System.out.print("Ingrese la categoría del evento: ");
        String categoria = sc.nextLine();
        System.out.print("Ingrese la duración aproximada del evento: ");
        String duracion = sc.nextLine();
        System.out.print("Ingrese la fecha del evento (dd/MM/yyyy): ");
        String fechaStr = sc.nextLine();

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = formato.parse(fechaStr);
            FabAbsTareas creador = new FabricaEvento(fecha);
            Evento nuevoEvento = (Evento) creador.crearTarea(titulo, info, categoria, duracion);
            cliente.addEvento(nuevoEvento);
            System.out.println("Evento creado");
        } catch (ParseException e) {
            System.out.println("Error: Formato de fecha inválido. Use dd/MM/yyyy");
        }
    }

    public static void verEventos(Cliente cliente) {
        ArrayList<Evento> listaEventos = cliente.getEventos();

        if(listaEventos.isEmpty()) {
            throw new ListaEventosVacia();
        } else {
            for(int i = 0; i < listaEventos.size(); i++) {
                System.out.println("["+ i + "] " + listaEventos.get(i));
            }
        }
    }

    public static void marcarEvento(Cliente cliente) {
        ArrayList<Evento> listaEventos = cliente.getEventos();

        if(listaEventos.isEmpty()) {
            throw new ListaEventosVacia();
        }

        verEventos(cliente);

        System.out.print("Seleccione un evento: ");
        int opc = sc.nextInt();
        sc.nextLine();

        if(opc >= 0 && opc < listaEventos.size()) {
            Evento evento = listaEventos.get(opc);
            if(evento.estadoEvento()) {
                System.out.println("Este evento ya está marcado como terminado");
            } else {
                cliente.completarEvento(opc);
                System.out.println("Evento marcado como terminado.");
            }
        } else {
            throw new ListaEventosVacia();
        }
    }

    public static void eliminarEvento(Cliente cliente) {
        ArrayList<Evento> listaEventos = cliente.getEventos();

        if(listaEventos.isEmpty()) {
            throw new ListaEventosVacia();
        }

        verEventos(cliente);
        System.out.print("Seleccione un evento: ");
        int opc = sc.nextInt();
        sc.nextLine();

        if(opc >= 0 && opc < listaEventos.size()) {
            listaEventos.remove(opc);
            System.out.println("Evento eliminado.");
        } else {
            throw new IndiceNoPermitido();
        }
    }

    public static void crearReto(Cliente cliente) {
        sc.nextLine();
        System.out.print("Ingrese el título del reto: ");
        String titulo = sc.nextLine();
        System.out.print("Añada una descripción del reto: ");
        String info = sc.nextLine();
        System.out.print("Ingrese la categoría del reto: ");
        String categoria = sc.nextLine();
        System.out.print("Ingrese la duración aproximada del reto: ");
        String duracion = sc.nextLine();

        FabAbsTareas creador = new FabricaReto();
        Reto nuevoReto = (Reto) creador.crearTarea(titulo, info, categoria, duracion);
        cliente.addReto(nuevoReto);
        System.out.println("Reto creado");
    }

    public static void verRetos(Cliente cliente) {
        ArrayList<Reto> listaRetos = cliente.getRetos();

        if(listaRetos.isEmpty()) {
            throw new ListaEventosVacia();
        } else {
            for(int i = 0; i < listaRetos.size(); i++) {
                System.out.println("[" + i + "] " + listaRetos.get(i));
            }
        }
    }

    public static void marcarReto(Cliente cliente) {
        ArrayList<Reto> listaRetos = cliente.getRetos();

        if(listaRetos.isEmpty()) {
            throw new ListaEventosVacia();
        }

        verRetos(cliente);

        System.out.print("Seleccione un reto: ");
        int opc = sc.nextInt();
        sc.nextLine();

        if(opc >= 0 && opc < listaRetos.size()) {
            Reto reto = listaRetos.get(opc);
            if(reto.isCompletado()) {
                System.out.println("Este reto ya está marcado como completado");
            } else {
                cliente.completarReto(opc);
                System.out.println("Reto marcado como completado");
            }
        } else {
            throw new ListaEventosVacia();
        }
    }

    public static void eliminarReto(Cliente cliente) {
        ArrayList<Reto> listaRetos = cliente.getRetos();

        if(listaRetos.isEmpty()) {
            throw new ListaEventosVacia();
        }

        verRetos(cliente);
        System.out.print("Seleccione un reto: ");
        int opc = sc.nextInt();
        sc.nextLine();

        if(opc >= 0 && opc < listaRetos.size()) {
            listaRetos.remove(opc);
            System.out.println("Reto eliminado");
        } else {
            throw new ListaEventosVacia();
        }
    }

    public static void verPuntos(Cliente cliente) {
        System.out.println("Esta es su cantidad de puntos: " + cliente.getPuntos());
    }

    public static void verRecompensas(Cliente cliente) {
        ArrayList<Recompensa> recompensas = ControlArchivos.cargarRecompensas();

        if(recompensas.isEmpty()) {
            throw new ListaRecompensasVacia();
        }

        System.out.println("Tienes: " + cliente.getPuntos() + " puntos");
        for(Recompensa r : recompensas) {
            System.out.printf("* [%s] %s - Costo: %d puntos\n",
                    r.getTipo(), r.getNombre(), r.getCosto());
        }
    }

    public static void canjearPuntos(Cliente cliente) {
        sc.nextLine();
        System.out.println("-- Canjear Recompensas --");

        ArrayList<Recompensa> recompensas = ControlArchivos.cargarRecompensas();

        if(recompensas.isEmpty()) {
            throw new ListaRecompensasVacia();
        }

        System.out.println("Tienes actualmente: " + cliente.getPuntos() + " puntos");

        for(int i = 0; i < recompensas.size(); i++) {
            Recompensa r = recompensas.get(i);
            System.out.printf("%d) [%s] %s - Costo: %d puntos\n",
                    i, r.getTipo(), r.getNombre(), r.getCosto());
        }

        System.out.println("Elige el número de la recompensa a canjear (o -1 para salir):");
        int opc = sc.nextInt();

        if(opc < 0 || opc >= recompensas.size()) {
            throw new IndiceNoPermitido();
        }

        Recompensa recompensaElegida = recompensas.get(opc);

        if(cliente.getPuntos() >= recompensaElegida.getCosto()) {

            recompensaElegida.canjear(cliente);

            System.out.println("Has canjeado: " + recompensaElegida.getNombre());
            System.out.println("Puntos restantes: " + cliente.getPuntos());

        } else {
            System.out.println("Puntos insuficientes. Te faltan " +
                    (recompensaElegida.getCosto() - cliente.getPuntos()) + " puntos");
        }
    }
}
