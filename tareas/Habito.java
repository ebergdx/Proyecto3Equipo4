package tareas;

import java.io.Serializable;

public class Habito implements Serializable {
    private String nombre;
    private String info;
    private String frecuencia;
    private String categoria;
    private short racha;

    public Habito(String nombre, String info, String frecuencia, String categoria, short racha) {
        this.nombre = nombre;
        this.info = info;
        this.frecuencia = frecuencia;
        this.categoria = categoria;
        this.racha = racha;
    }

    public String getNombre() {
        return nombre;
    }

    public String getInfo() {
        return info;
    }

    public String getFrecuencia() {
        return frecuencia;
    }
    
    public String getCategoria() {
        return categoria;
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

    @Override
    public String toString() {
        return "\tInformación del hábito " + nombre +
        "| Descripción: " + info +
        "| Frecuencia: " + frecuencia +
        "| Categoria: " + categoria +
        "| Racha de Días: " + racha;
    }
}
