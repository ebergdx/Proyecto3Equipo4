package tareas;

public class Reto extends Tareas {
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

    public boolean isCompletado() {
        return completado;
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

    @Override
    public void mostrarInfo() {
        System.out.println("Reto: " + titulo);
        System.out.println("Descripción: " + info);
        System.out.println("Categoría: " + categoria);
        System.out.println("Duración: " + duracion);
        System.out.println("Estado: " + (completado ? "Completado" : "En progreso"));
    }

    @Override
    public String toString() {
        return "\tInformación del reto " + titulo +
                " | Descripción: " + info +
                " | Categoría: " + categoria +
                " | Duración: " + duracion +
                " | Estado: " + (completado ? "Completado" : "En progreso");
    }
}