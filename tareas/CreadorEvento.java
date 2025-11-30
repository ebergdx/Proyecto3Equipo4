package tareas;

import java.util.Date;

public class CreadorEvento extends CreadorTarea {
    private Date fecha;
    
    public CreadorEvento(Date fecha) {
        this.fecha = fecha;
    }
    
    @Override
    public Tareas crearTarea(String titulo, String info, String categoria, String duracion) {
        return new Evento(titulo, info, categoria, duracion, fecha);
    }
}
