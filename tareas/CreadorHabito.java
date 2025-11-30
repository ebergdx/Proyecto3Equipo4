package tareas;

public class CreadorHabito extends CreadorTarea {
    @Override
    public Tareas crearTarea(String titulo, String info, String categoria, String duracion) {
        return new Habito(titulo, info, duracion, categoria);
    }
}
