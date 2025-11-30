package eventos;

import usuarios.Cliente;

public class EventoUsuario {
    public static final String habitoCompletado = "habitoCompletado";
    public static final String eventoTerminado = "eventoTerminado";
    public static final String retoCompletado = "retoCompletado";
    public static final String puntosGanados = "puntosGanados";
    public static final String logroDesbloqueado = "logroDesbloqueado";
    
    private String tipo;
    private Cliente cliente;
    private int puntos;
    private String mensaje;
    
    public EventoUsuario(String tipo, Cliente cliente, int puntos, String mensaje) {
        this.tipo = tipo;
        this.cliente = cliente;
        this.puntos = puntos;
        this.mensaje = mensaje;
    }
    
    public String getTipo() { 
        return tipo; 
    }
    
    public Cliente getCliente() { 
        return cliente; 
    }
    
    public int getPuntos() { 
        return puntos; 
    }
    
    public String getMensaje() { 
        return mensaje; 
    }
}
