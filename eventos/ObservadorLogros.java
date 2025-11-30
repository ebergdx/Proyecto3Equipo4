package eventos;

import usuarios.Cliente;
import tareas.Reto;

public class ObservadorLogros implements ObservadorEventos {
    @Override
    public void eventoGenerado(EventoUsuario evento) {
        switch (evento.getTipo()) {
            case EventoUsuario.habitoCompletado:
                verificarLogroHabitos(evento.getCliente());
                break;
            case EventoUsuario.puntosGanados:
                verificarLogroPuntos(evento.getCliente(), evento.getPuntos());
                break;
            case EventoUsuario.retoCompletado:
                verificarLogroRetos(evento.getCliente());
                break;
        }
    }
    
    private void verificarLogroHabitos(Cliente cliente) {
        int totalHabitos = cliente.getHabitos().size();
        if (totalHabitos >= 5) {
            desbloquearLogro(cliente, "Coleccionista de Habitos");
        }
    }
    
    private void verificarLogroPuntos(Cliente cliente, int puntosGanados) {
        int puntosTotales = cliente.getPuntos();
        if (puntosTotales >= 1000) {
            desbloquearLogro(cliente, "Maestro de la Productividad");
        }
    }
    
    private void verificarLogroRetos(Cliente cliente) {
        int retosCompletados = 0;
        for (Reto reto : cliente.getRetos()) {
            if (reto.isCompletado()) {
                retosCompletados++;
            }
        }
        if (retosCompletados >= 3) {
            desbloquearLogro(cliente, "Cazador de Retos");
        }
    }
    
    private void desbloquearLogro(Cliente cliente, String logro) {
        if (!cliente.getLogros().contains(logro)) {
            cliente.agregarLogro(logro);
            System.out.println("Logro desbloqueado: " + logro + " - Usuario: " + cliente.getNombre());
        }
    }
}
