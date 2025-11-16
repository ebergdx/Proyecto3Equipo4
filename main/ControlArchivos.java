package main;


import usuarios.*;
import java.io.*;
import tareas.*;
import java.util.ArrayList;

public class ControlArchivos {
    public static final String CLIENTES_REGISTRO = "usuarios.bin";
    public static final String ADMINS_REGISTRO = "admins.bin";

    public static void guardarClientes(ArrayList<Usuario> usuarios) {
        try {
            OutputStream is = new FileOutputStream(CLIENTES_REGISTRO);
            ObjectOutputStream oos = new ObjectOutputStream(is);
            oos.writeObject(oos);
            oos.close();
        } catch(IOException e) {
            System.out.println("Excepción: Usuarios no almacenados correctamente.");
        }
    }

    public static void sesionCliente(String email, int password) {
        for(Usuario usuario : usuarios) {
            if(usuario.getEmail().equals(email))
        }
    }

    public static void sesionUsuario(String email, int password, short clave) {

    }

    public static void verUsuarios(ArrayList<Usuario> usuarios) {
        try {
            InputStream is = new FileInputStream(CLIENTES_REGISTRO);
            ObjectInputStream ois = new ObjectInputStream(is);
            
            Usuario usuario = (Usuario)ois.readObject();

            for(int i = 0; i < usuarios.size(); i++) {
                System.out.println(usuario);
            }
            
            ois.close();
        } catch(IOException e) {
            System.out.println("Excepción: Archivo no leído.");
        } catch(ClassNotFoundException e) {
            System.out.println("Excepción: Clase no encontrada.");
        }
    }
}
