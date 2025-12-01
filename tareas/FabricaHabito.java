package tareas;

public class FabricaHabito implements FabAbsTareas {
    @Override
    public Tareas crearTarea(String titulo, String info, String categoria, String duracion) {
        return new Habito(titulo, info, duracion, categoria);
    }
}
