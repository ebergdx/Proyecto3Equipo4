package tareas;

import java.util.Date;

public class Evento extends Tareas {
    private Date fecha;
    private boolean terminado;

    public Evento(String titulo, String info, String categoria, String duracion, Date fecha) {
        super(titulo, info, categoria, duracion);
        this.fecha = fecha;
        this.terminado = false;
    }

    public void eventoTerminado() {
        this.terminado = true;
    }

    public boolean estadoEvento() {
        return terminado;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isTerminado() {
        return terminado;
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

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Evento: " + titulo);
        System.out.println("Descripción: " + info);
        System.out.println("Categoría: " + categoria);
        System.out.println("Duración: " + duracion);
        System.out.println("Fecha: " + fecha);
        System.out.println("Estado: " + (terminado ? "Terminado" : "En progreso"));
    }

    @Override
    public String toString() {
        return "\tInformación del evento " + titulo +
                " | Descripción: " + info +
                " | Categoría: " + categoria +
                " | Duración: " + duracion +
                " | Fecha: " + fecha +
                " | Estado: " + (terminado ? "Terminado" : "En progreso");
    }
}