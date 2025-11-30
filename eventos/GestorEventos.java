package eventos;

import java.util.ArrayList;
import java.util.List;

public class GestorEventos {
    private static GestorEventos instancia;
    private List<ObservadorEventos> observadores;
    
    private GestorEventos() {
        this.observadores = new ArrayList<>();
    }
    
    public static GestorEventos getInstancia() {
        if (instancia == null) {
            instancia = new GestorEventos();
        }
        return instancia;
    }
    
    public void agregarObservador(ObservadorEventos observador) {
        observadores.add(observador);
    }
    
    public void removerObservador(ObservadorEventos observador) {
        observadores.remove(observador);
    }
    
    public void notificarEvento(EventoUsuario evento) {
        for (ObservadorEventos observador : observadores) {
            observador.eventoGenerado(evento);
        }
    }
}
