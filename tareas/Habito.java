package tareas;

import java.io.Serializable;

public class Habito extends Tareas implements Serializable {
    private String frecuencia;
    private short racha;

    public Habito(String titulo, String info, String frecuencia, String categoria, short racha) {
        super(titulo, info, categoria, null);
        this.frecuencia = frecuencia;
        this.racha = racha;
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    public short getRacha() {
        return racha;
    }

    public void diaRacha() {
        this.racha++;
    }

    public void resetRacha() {
        this.racha = 0;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Información del hábito: " + titulo);
        System.out.println("Descripción: " + info);
        System.out.println("Frecuencia: " + frecuencia);
        System.out.println("Categoría: " + categoria);
        System.out.println("Racha de días: " + racha);
    }

    @Override
    public String toString() {
        return "\tInformación del hábito " + titulo +
        " | Descripción: " + info +
        " | Frecuencia: " + frecuencia +
        " | Categoría: " + categoria +
        " | Racha de días: " + racha;
    }
}
