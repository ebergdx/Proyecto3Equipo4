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
        
        for(Cliente c : clientes) {
            emails.add(c.getEmail());
        }
        for(Admin a : admins) {
            emails.add(a.getEmail());
        }
    }
    
    public static void finalizar() {
        ArrayList<Usuario> clientesUsuarios = new ArrayList<>(clientes);
        ArrayList<Usuario> adminsUsuarios = new ArrayList<>(admins);
        
        ControlArchivos.guardarClientes(clientesUsuarios);
        ControlArchivos.guardarAdmins(adminsUsuarios);
    }
    
    public static void iniciarSesion() {
        int intentos = 3;
        
        do {
            try {
                System.out.print("Email: ");
                String correo = sc.nextLine();
                System.out.print("Contraseña: ");
                int password = sc.nextInt();
                sc.nextLine();
                
                System.out.print("¿Es administrador? (1=Sí, 0=No): ");
                int opc = sc.nextInt();
                sc.nextLine();
                
                if(opc == 1) {
                    System.out.print("Ingrese su clave de administrador: ");
                    short clave = sc.nextShort();
                    sc.nextLine();
                    
                    Admin admin = buscarAdmin(correo, password, clave);
                    if(admin != null) {
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
                    if(cliente != null) {
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
                
                if(intentos > 0) {
                    System.out.println("Intentos restantes: " + intentos + "\n");
                }
                
            } catch(InputMismatchException e) {
                intentos--;
                sc.nextLine();
                System.out.println("Excepción: Solo puede usar números enteros para la contraseña.");
                if(intentos > 0) {
                    System.out.println("Inténtelo nuevamente");
                }
            }
        } while(intentos > 0);
        
        if(intentos == 0) {
            System.out.println("Demasiados intentos fallidos");
        }
    }
    
    public static void crearCuenta() {
        int intentos = 3;
        String nombre = "";
        String email = "";
        int password = 0;
        
        System.out.println("\nCrear Nueva Cuenta");
        
        do {
            try {
                System.out.print("Nombre: ");
                nombre = sc.nextLine();
                
                System.out.print("Correo: ");
                email = sc.nextLine();
                validarCorreoExistente(email);
                
                System.out.print("Contraseña (números entero): ");
                password = sc.nextInt();
                sc.nextLine();
                
                emails.add(email);
                break;
                
            } catch(InputMismatchException e) {
                intentos--;
                sc.nextLine();
                System.out.println("Excepción: Solo puede usar números enteros para la contraseña");
                if(intentos > 0) {
                    System.out.println("Inténtelo nuevamente");
                }
            } catch(CorreoYaExistente e) {
                intentos--;
                System.out.println("✗ " + e.getMessage());
                if(intentos > 0) {
                    System.out.println("Inténtelo nuevamente");
                }
            }
        } while(intentos > 0);
        
        if(intentos == 0) {
            System.out.println("No se pudo crear la cuenta");
            return;
        }
        
        System.out.print("\n¿Es administrador? (1=Sí, 0=No): ");
        int opc = sc.nextInt();
        sc.nextLine();
        
        if(opc == 1) {
            crearCuentaAdmin(nombre, email, password);
        } else {
            crearCuentaCliente(nombre, email, password);
        }
    }
    
    private static void crearCuentaAdmin(String nombre, String email, int password) {
        int intentos = 3;
        
        do {
            try {
                System.out.print("Ingrese su clave de administrador (número): ");
                short clave = sc.nextShort();
                sc.nextLine();
                
                Admin nuevoAdmin = new Admin(nombre, email, password, clave);
                admins.add(nuevoAdmin);
                
                System.out.println("\nCuenta de administrador creada");
                finalizar();
                return;
                
            } catch(InputMismatchException e) {
                intentos--;
                sc.nextLine();
                System.out.println("Ingrese un número entero para su clave");
                if(intentos > 0) {
                    System.out.println("Intentos restantes: " + intentos);
                }
            }
        } while(intentos > 0);
        
        System.out.println("No se pudo crear la cuenta");
    }
    
    private static void crearCuentaCliente(String nombre, String email, int password) {
        System.out.print("Fecha de nacimiento: ");
        String fechaNacimiento = sc.nextLine();
        
        Cliente nuevoCliente;
        if(fechaNacimiento.trim().isEmpty()) {
            nuevoCliente = new Cliente(nombre, email, password, "01/01/2000");
        } else {
            nuevoCliente = new Cliente(nombre, email, password, fechaNacimiento);
        }
        
        clientes.add(nuevoCliente);
        System.out.println("\nCuenta creada");
        finalizar();
    }
    
    private static Cliente buscarCliente(String email, int password) {
        for(Cliente c : clientes) {
            if(c.getEmail().equals(email) && c.getPassword() == password) {
                return c;
            }
        }
        return null;
    }
    
    private static Admin buscarAdmin(String email, int password, short clave) {
        for(Admin a : admins) {
            if(a.getEmail().equals(email) && a.getPassword() == password && a.getClave() == clave) {
                return a;
            }
        }
        return null;
    }
    
    public static void validarCorreoExistente(String email) throws CorreoYaExistente {
        if(emails.contains(email)) {
            throw new CorreoYaExistente();
        }
    }
}