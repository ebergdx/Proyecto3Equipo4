package usuarios;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Cliente extends Usuario {
    private String fechaNacimiento;
    private int puntos;
    //private List<Habito> habitos;

    public Cliente(String nombre, String email, int id, String fechaNacimiento, int puntos) {
        super(nombre, email, id);
        this.fechaNacimiento = fechaFormato(fechaNacimiento);
        this.puntos = puntos;
    }

    public int getPuntos() {
        return puntos;
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