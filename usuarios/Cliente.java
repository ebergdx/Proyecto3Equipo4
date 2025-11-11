package usuarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import tareas.*;

public class Cliente extends Usuario {
    private String fechaNacimiento;
    private int puntos;
    private ArrayList<Habito> habitos;

    public Cliente(String nombre, String email, int password, String fechaNacimiento) {
        super(nombre, email, password);
        this.fechaNacimiento = fechaFormato(fechaNacimiento);
        this.habitos = new ArrayList<>();
        this.puntos = 0;
    }

    public int getPuntos() {
        return puntos;
    }

    public void addHabito(Habito newHabito) {
        habitos.add(newHabito);
    }

    public void deleteHabito(int id) {
        habitos.remove(id);
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
