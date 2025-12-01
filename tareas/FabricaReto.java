package tareas;

public class FabricaReto implements FabAbsTareas {
    @Override
    public Tareas crearTarea(String titulo, String info, String categoria, String duracion) {
        return new Reto(titulo, info, categoria, duracion);
    }
}
