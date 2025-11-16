package main;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

import excepciones.CorreoExistenteException;
import usuarios.*;

public class Sistema {
    private static Scanner sc = new Scanner(System.in);
    public static ObjectOutputStream usuarios;
    public static Set<String> emails;
    public static void main(String[] args) {
        System.out.println("- Bienvenido a la aplicación para registrar hábitos -");
        int opc;

        do {
            System.out.println("1)Iniciar sesión\n2)Crear cuenta\n0)Salir");
            opc = sc.nextInt();
            sc.nextLine();

            switch(opc) {
                case 1 -> iniciarSesion();
                case 2 -> crearCuenta();
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Ingrese una opción válida");
            }
        } while(opc != 0);
    }

    private static void iniciarSesion() {
        int i = 3;
        Usuario ingresoUsuario;

        System.out.println("\t|Ingrese los datos de su cuenta|\n");
        do {
            try {
                System.out.println("Email: ");
                String correo = sc.nextLine();
                System.out.println("Contraseña: ");
                int contrasenia = sc.nextInt();

                System.out.println("1)Sí\notro)No\n¿Es administrador?: ");
                int opc = sc.nextInt();
                sc.nextLine();

                if(opc == 1) {
                    System.out.println("Ingrese su clave: ");
                    Short clave = sc.nextShort();
                    
                } else {

                }



                break;
            } catch(InputMismatchException e) {
                i--;
                sc.nextLine();
                System.out.println("Excepción: Solo puede usar números enteros para la contraseña.");
                System.out.println("\n\t- Inténtelo nuevamente, le quedan" + i +  "intentos -");
            }
        } while(i > 0);

        if(i == 0) {
            System.out.println("Contraseña incorrecta.");
            return;
        }
    }

    private static void crearCuenta() {
        int i = 3;
    
        System.err.println("\t|Por favor, ingrese los siguientes datos para crear su cuenta|\n");
        do {
            try {
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();
                System.out.println("Correo: ");
                String email = sc.nextLine();
                correoExistente(email);

                System.out.println("Contraseña: ");
                int contrasenia = sc.nextInt();
                emails.add(email);
                break;
            } catch(InputMismatchException e) {
                i--;
                sc.nextLine();
                System.out.println("Excepción: Solo puede usar números enteros para la contraseña.");
                System.out.println("\n\t- Inténtelo nuevamente, le quedan" + i +  "intentos -");
            }
        } while(i > 0);

        if(i == 0) {
            System.out.println("Contraseña incorrecta.");
            return;
        }

        System.out.println("1)Sí\2)No\n¿Es administrador?");
        int opc = sc.nextInt();

        Usuario nuevoUsuario;
        if(opc == 1) {
            int j = 3;
            do {
                try {
                    System.out.println("Ingrese su clave: ");
                    short clave = sc.nextShort();
                    nuevoUsuario = new Admin(nombre, email, contrasenia, clave);
                    break;
                } catch(InputMismatchException e) {
                    j--;
                    System.out.println("Ingrese un número entero para su clave.");
                } catch(CorreoExistenteException e) {
                    j--;
                    e.printStackTrace();
                }
            } while(j > 0);
        } else {
            nuevoUsuario = new Cliente(nombre, email, contraseña);
        }

        try {
            usuarios.writeObject(nuevoUsuario);
            usuarios.close();
        } catch(IOException e) {
            System.out.println("Excepción: Archivo no encontrado.");
        }
    }

    public static void correoExistente(String email) throws CorreoExistenteException {
        for(String correoExistente : emails) {
            if(correoExistente.equals(email)) {
                throw new CorreoExistenteException();
            }
        }
    }
}
