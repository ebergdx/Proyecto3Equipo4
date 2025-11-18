package usuarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import tareas.*;

public class Cliente extends Usuario {
    private String fechaNacimiento;
    private int puntos;
    private ArrayList<Habito> habitos;
    private ArrayList<String> logros;
    private ArrayList<String> items;

    public Cliente(String nombre, String email, int password, String fechaNacimiento) {
        super(nombre, email, password);
        this.fechaNacimiento = fechaFormato(fechaNacimiento);
        this.habitos = new ArrayList<>();
        this.puntos = 0;
        this.logros = new ArrayList<>();
        this.items = new ArrayList<>();
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
        }
    }

    public void addHabito(Habito newHabito) {
        habitos.add(newHabito);
    }

    public void deleteHabito(int id) {
        habitos.remove(id);
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

    public ArrayList<Habito> getHabitos() {
        return habitos;
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
