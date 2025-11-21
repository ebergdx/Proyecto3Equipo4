package tareas;

import java.io.Serializable;

public abstract class Tareas implements Serializable {
    protected String titulo;
    protected String info;
    protected String categoria;
    protected String duracion;

    public Tareas(String titulo, String info, String categoria, String duracion) {
        this.titulo = titulo;
        this.info = info;
        this.categoria = categoria;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getInfo() {
        return info;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getDuracion() {
        return duracion;
    }

    public abstract void mostrarInfo();
}