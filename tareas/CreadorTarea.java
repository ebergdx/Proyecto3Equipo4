package tareas;

public abstract class CreadorTarea {
    public abstract Tareas crearTarea(String titulo, String info, String categoria, String duracion);
    
    public final Tareas crearYConfigurarTarea(String titulo, String info, String categoria, String duracion) {
        Tareas tarea = crearTarea(titulo, info, categoria, duracion);
        System.out.println("Tarea creada: " + titulo);
        return tarea;
    }
}
