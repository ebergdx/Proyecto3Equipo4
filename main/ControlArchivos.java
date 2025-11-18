package main;


import usuarios.*;
import java.io.*;
import tareas.*;
import java.util.ArrayList;

import recompensas.Recompensa;

public class ControlArchivos {
    public static final String CLIENTES_REGISTRO = "usuarios.bin";
    public static final String ADMINS_REGISTRO = "admins.bin";
    public static final String RECOMPENSAS_REGISTRO = "recompensas.bin";

    public static void guardarClientes(ArrayList<Usuario> usuarios) {
        try {
            OutputStream os = new FileOutputStream(CLIENTES_REGISTRO);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(usuarios);
            oos.close();
            os.close();
        } catch(IOException e) {
            System.out.println("Excepción: Usuarios no almacenados correctamente.");
        }
    }

    public static ArrayList<Usuario> cargarClientes() {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(CLIENTES_REGISTRO);
            ObjectInputStream ois = new ObjectInputStream(is);
            usuarios = (ArrayList<Usuario>) ois.readObject();
            ois.close();
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de usuarios no encontrado.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Excepción: Archivo de usuarios no leído.");
            e.printStackTrace();
        }
        return usuarios;
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

    public static void guardarRecompensas(ArrayList<Recompensa> recompensas) {
        try {
            OutputStream os = new FileOutputStream(RECOMPENSAS_REGISTRO); 
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(recompensas); 
            oos.close();
            os.close();
        } catch(IOException e) {
            System.out.println("Excepción: Recompensas no almacenadas correctamente.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Recompensa> cargarRecompensas() {
        ArrayList<Recompensa> recompensas = new ArrayList<>();
        
        try {
            InputStream is = new FileInputStream(RECOMPENSAS_REGISTRO); 
            ObjectInputStream ois = new ObjectInputStream(is);
            recompensas = (ArrayList<Recompensa>) ois.readObject(); 
            ois.close();
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de recompensas no encontrado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Excepción: Archivo de recompensas no leído.");
            e.printStackTrace();
        }
        
        return recompensas;
    }
}
