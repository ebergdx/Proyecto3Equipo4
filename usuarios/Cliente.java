package usuarios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import excepciones.PuntosInsuficientes;
import tareas.*;

public class Cliente extends Usuario {
    private String fechaNacimiento;
    private int puntos;
    private ArrayList<Habito> habitos;
    private ArrayList<Evento> eventos;
    private ArrayList<Reto> retos;
    private ArrayList<String> logros;
    private ArrayList<String> items;

    public Cliente(String nombre, String email, String password, String fechaNacimiento) {
        super(nombre, email, password);
        this.fechaNacimiento = fechaFormato(fechaNacimiento);
        this.habitos = new ArrayList<>();
        this.eventos = new ArrayList<>();
        this.retos = new ArrayList<>();
        this.logros = new ArrayList<>();
        this.items = new ArrayList<>();
        this.puntos = 0;
    }

    public int getPuntos() {
        return puntos;
    }

    public void agregarPuntos(int pts) {
        if (pts > 0) {
            this.puntos += pts;
        }
    }

    public void restarPuntos(int pts) {
        if (pts > 0 && pts <= puntos) {
            this.puntos -= pts;
        } else {
            throw new PuntosInsuficientes();
        }
    }

    public ArrayList<Habito> getHabitos() {
        return habitos;
    }

    public void addHabito(Habito newHabito) {
        habitos.add(newHabito);
    }

    public void deleteHabito(int id) {
        habitos.remove(id);
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void addEvento(Evento nuevoEvento) {
        eventos.add(nuevoEvento);
    }

    public void deleteEvento(int id) {
        eventos.remove(id);
    }

    public ArrayList<Reto> getRetos() {
        return retos;
    }

    public void addReto(Reto nuevoReto) {
        retos.add(nuevoReto);
    }

    public void deleteReto(int id) {
        retos.remove(id);
    }

    public void agregarLogro(String logro) {
        logros.add(logro);
    }

    public void agregarItem(String item) {
        items.add(item);
    }

    public ArrayList<String> getLogros() {
        return logros;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Correo: " + this.email);
        System.out.println("Fecha de Nacimiento: " + this.fechaNacimiento);
        System.out.println("Hábitos: " + this.habitos.size());
        System.out.println("Eventos: " + this.eventos.size());
        System.out.println("Retos: " + this.retos.size());
        System.out.println("Logros: " + logros.size());
        System.out.println("Items: " + items.size());
        System.out.println("Puntos: " + this.puntos);

        int habitosActivos = 0;
        for (Habito habito : habitos) {
            if (habito.getRacha() > 0) {
                habitosActivos++;
            }
        }
        System.out.println("Hábitos Activos: " + habitosActivos);
    }

    public String fechaFormato(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaNacimiento = formato.parse(fecha);
            return formato.format(fechaNacimiento);
        } catch (Exception e) {
            return "Fecha Inválida";
        }
    }
}