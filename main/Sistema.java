package main;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;
import excepciones.CorreoYaExistente;
import usuarios.*;

public class Sistema {
    private static Scanner sc = new Scanner(System.in);
    public static ArrayList<Cliente> clientes = new ArrayList<>();
    public static ArrayList<Admin> admins = new ArrayList<>();
    public static Set<String> emails = new HashSet<>();

    public static void inicializar() {
        clientes = ControlArchivos.cargarClientes();
        admins = ControlArchivos.cargarAdmins();

        for (Cliente c : clientes) {
            emails.add(c.getEmail());
        }
        for (Admin a : admins) {
            emails.add(a.getEmail());
        }
    }

    public static void finalizar() {
        ControlArchivos.guardarClientes(clientes);
        ControlArchivos.guardarAdmins(admins);
    }

    public static void iniciarSesion() {
        int intentos = 3;

        do {
            try {
                System.out.print("Email: ");
                String correo = sc.nextLine();
                System.out.print("Contraseña: ");
                String password = sc.nextLine();

                System.out.print("¿Es administrador? (1=Sí, 0=No): ");
                int opc = sc.nextInt();
                sc.nextLine();

                if (opc == 1) {
                    System.out.print("Ingrese su clave de administrador: ");
                    String clave = sc.nextLine();

                    Admin admin = buscarAdmin(correo, password, clave);
                    if (admin != null) {
                        admin.iniciarSesion();
                        System.out.println("Bienvenido, " + admin.getNombre());
                        menuAdmin.Administrar(admin);
                        admin.cerrarSesion();
                        finalizar();
                        return;
                    } else {
                        System.out.println("Datos de administrador incorrectas");
                        intentos--;
                    }
                } else {
                    Cliente cliente = buscarCliente(correo, password);
                    if (cliente != null) {
                        cliente.iniciarSesion();
                        System.out.println("\nBienvenido, " + cliente.getNombre());
                        menuCliente.AppCliente(cliente);
                        cliente.cerrarSesion();
                        finalizar();
                        return;
                    } else {
                        System.out.println("Datos incorrectos");
                        intentos--;
                    }
                }

                if (intentos > 0) {
                    System.out.println("Intentos restantes: " + intentos + "\n");
                }

            } catch (InputMismatchException e) {
                intentos--;
                sc.nextLine();
                System.out.println("Excepción: Solo puede usar números enteros para la contraseña.");
                if (intentos > 0) {
                    System.out.println("Inténtelo nuevamente");
                }
            }
        } while (intentos > 0);

        if (intentos == 0) {
            System.out.println("Demasiados intentos fallidos");
        }
    }

    public static void crearCuenta() {
        int intentos = 3;
        String nombre = "";
        String email = "";
        String password = "";

        System.out.println("\nCrear Nueva Cuenta");

        do {
            try {
                System.out.print("Nombre: ");
                nombre = sc.nextLine();

                System.out.print("Correo: ");
                email = sc.nextLine();
                validarCorreoExistente(email);

                System.out.print("Contraseña: ");
                password = sc.nextLine();

                break;

            } catch (InputMismatchException e) {
                intentos--;
                sc.nextLine();
                System.out.println("Excepción: Solo puede usar números enteros para la contraseña");
                if (intentos > 0) {
                    System.out.println("Inténtelo nuevamente");
                }
            } catch (CorreoYaExistente e) {
                intentos--;
                System.out.println("✗ " + e.getMessage());
                if (intentos > 0) {
                    System.out.println("Inténtelo nuevamente");
                }
            }
        } while (intentos > 0);

        try {
            System.out.print("\n¿Es administrador? (1=Sí, 0=No): ");
            int opc = sc.nextInt();
            sc.nextLine();

            UsuarioFabAbs fabrica;
            String datoExtra;

            if (opc == 1) {
                fabrica = new FabricaAdmin();
                System.out.print("Ingrese su clave de administrador: ");
                datoExtra = sc.nextLine();

                Usuario nuevoAdmin = fabrica.crearUsuario(nombre, email, password, datoExtra);
                admins.add((Admin) nuevoAdmin);
                System.out.println("Cuenta Admin creada.");

            } else {
                fabrica = new FabricaCliente();
                System.out.print("Fecha de nacimiento (dd/mm/aaaa): ");
                datoExtra = sc.nextLine();
                if (datoExtra.trim().isEmpty())
                    datoExtra = "01/01/2000";

                Usuario nuevoCliente = fabrica.crearUsuario(nombre, email, password, datoExtra);
                clientes.add((Cliente) nuevoCliente);
                System.out.println("Cuenta Cliente creada.");
            }

            emails.add(email);
            finalizar();

        } catch (InputMismatchException e) {
            sc.nextLine();
            System.out.println("Opción inválida.");
        } catch (Exception e) {
            System.out.println("Error al crear usuario: " + e.getMessage());
        }
    }

    private static Cliente buscarCliente(String email, String password) {
        for (Cliente c : clientes) {
            if (c.getEmail().equals(email) && c.getPassword().equals(password)) {
                return c;
            }
        }
        return null;
    }

    private static Admin buscarAdmin(String email, String password, String clave) {
        for (Admin a : admins) {
            if (a.getEmail().equals(email) && a.getPassword().equals(password) && a.getClave().equals(clave)) {
                return a;
            }
        }
        return null;
    }

    public static void validarCorreoExistente(String email) throws CorreoYaExistente {
        if (emails.contains(email)) {
            throw new CorreoYaExistente();
        }
    }
}