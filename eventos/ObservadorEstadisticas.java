package eventos;

public class ObservadorEstadisticas implements ObservadorEventos {
    private int totalPuntosRepartidos = 0;
    private int totalTareasCompletadas = 0;
    
    @Override
    public void eventoGenerado(EventoUsuario evento) {
        switch(evento.getTipo()) {
            case EventoUsuario.habitoCompletado:
            case EventoUsuario.eventoTerminado:
            case EventoUsuario.retoCompletado:
                totalTareasCompletadas++;
                break;
            case EventoUsuario.puntosGanados:
                totalPuntosRepartidos += evento.getPuntos();
                break;
        }
        
        if(totalTareasCompletadas % 5 == 0) {
            System.out.println("Estadisticas: " + totalTareasCompletadas + 
                             " tareas completadas, " + totalPuntosRepartidos + " puntos repartidos");
        }
    }
}
