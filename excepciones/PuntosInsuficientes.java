package excepciones;

public class PuntosInsuficientes extends RuntimeException {
    public PuntosInsuficientes() {
        super("Excepción: No hay suficientes puntos.");
    }
}