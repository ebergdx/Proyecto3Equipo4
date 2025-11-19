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

    @Override
    public void mostrarInfo() {
        System.out.println("Evento: " + titulo);
        System.out.println("Descripción: " + info);
        System.out.println("Categoría: " + categoria);
        System.out.println("Duración: " + duracion);
        System.out.println("Fecha: " + fecha);
        System.out.println("Estado: " + (terminado ? "Terminado" : "En progreso"));
    }
}
