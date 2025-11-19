package tareas;

import java.io.Serializable;

public class Reto extends Tareas implements Serializable {
    private boolean completado;

    public Reto(String titulo, String info, String categoria, String duracion) {
        super(titulo, info, categoria, duracion);
        this.completado = false;
    }

    public void marcarCompletado() {
        this.completado = true;
    }

    public boolean Completado() {
        return completado;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Reto: " + titulo);
        System.out.println("Descripción: " + info);
        System.out.println("Categoría: " + categoria);
        System.out.println("Duración: " + duracion);
        System.out.println("Estado: " + (completado ? "Completado" : "En progreso"));
    }
}