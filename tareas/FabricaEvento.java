package tareas;

import java.util.Date;

public class FabricaEvento implements FabAbsTareas {
    private Date fecha;
    
    public FabricaEvento(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public Tareas crearTarea(String titulo, String info, String categoria, String duracion) {
        return new Evento(titulo, info, categoria, duracion, fecha);
    }
}
