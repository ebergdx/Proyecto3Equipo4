package main;

import usuarios.*;
import java.io.*;
import tareas.*;
import java.util.ArrayList;

import excepciones.UsuarioNoEncontrado;
import recompensas.Recompensa;

public class ControlArchivos {
    public static final String CLIENTES_REGISTRO = "usuarios.bin";
    public static final String ADMINS_REGISTRO = "admins.bin";
    public static final String RECOMPENSAS = "recompensas.bin";
    public static final String HABITOS = "habitos.bin";

    public static void guardarClientes(ArrayList<Usuario> clientes) {
        try {
            OutputStream os = new FileOutputStream(CLIENTES_REGISTRO);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(clientes);
            oos.close();
        } catch(IOException e) {
            System.out.println("Excepción: Usuarios no almacenados correctamente.");
            e.printStackTrace();
        }
    }

    public static ArrayList<Cliente> cargarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(CLIENTES_REGISTRO);
            ObjectInputStream ois = new ObjectInputStream(is);
            clientes = (ArrayList<Cliente>) ois.readObject();
            ois.close();
            is.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de clientes no encontrado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Excepción: Archivo de usuarios no leído.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Excepción: Archivo de clientes no leído.");
            e.printStackTrace();
        } catch(ClassCastException e) {
            System.out.println("Excepción: Error de casteo.");
            e.printStackTrace();
        }
        return clientes;
    }

    public static void verClientes(ArrayList<Usuario> usuarios) {
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
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            System.out.println("Excepción: Clase no encontrada.");
            e.printStackTrace();
        }
    }

    public static void guardarAdmins(ArrayList<Usuario> admins) {
        try {
            OutputStream os = new FileOutputStream(ADMINS_REGISTRO);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(admins);
            oos.close();
        } catch(IOException e) {
            System.out.println("Excepción: Usuarios no almacenados correctamente.");
        }
    }

    public static ArrayList<Admin> cargarAdmins() {
        ArrayList<Admin> admins = new ArrayList<>();
        try {
            InputStream is = new FileInputStream(ADMINS_REGISTRO);
            ObjectInputStream ois = new ObjectInputStream(is);
            admins = (ArrayList<Admin>) ois.readObject();
            ois.close();
            is.close();
        } catch(FileNotFoundException e) {
            System.out.println("Archivo de usuarios no encontrado.");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("Excepción: Archivo de usuarios no leído.");
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            System.out.println("Excepción: Archivo de clientes no leído.");
            e.printStackTrace();
        } catch(ClassCastException e) {
            System.out.println("Excepción: Error de casteo.");
            e.printStackTrace();
        }
        return admins;
    }

    public static void guardarRecompensas(ArrayList<Recompensa> recompensas) {
        try {
            OutputStream os = new FileOutputStream(RECOMPENSAS);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(recompensas);
            oos.close();
        } catch(IOException e) {
            System.out.println("Excepción: Usuarios no almacenados correctamente.");
        }
    }

    public static ArrayList<Recompensa> cargarRecompensas() {
        ArrayList<Recompensa> recompensas = new ArrayList<>();
        
        try {
            InputStream is = new FileInputStream(RECOMPENSAS); 
            ObjectInputStream ois = new ObjectInputStream(is);
            recompensas = (ArrayList<Recompensa>) ois.readObject(); 
            ois.close();
            is.close();
        } catch(FileNotFoundException e) {
            System.out.println("Archivo de usuarios no encontrado.");
            e.printStackTrace();
        } catch(IOException e) {
            System.out.println("Excepción: Archivo de usuarios no leído.");
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            System.out.println("Excepción: Archivo de clientes no leído.");
            e.printStackTrace();
        } catch(ClassCastException e) {
            System.out.println("Excepción: Error de casteo.");
            e.printStackTrace();
        }
        return recompensas;
    }

    public static void verClientes() {
        ArrayList<Cliente> clientes = cargarClientes();
        if(clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for(Cliente cliente : clientes) {
            System.out.println(cliente);
        }
    }

    public static void verAdmins() {
        ArrayList<Admin> admins = cargarAdmins();
        if(admins.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        for(Admin admin : admins) {
            System.out.println(admins);
        }
    }
}
