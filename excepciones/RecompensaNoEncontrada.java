package excepciones;

public class RecompensaNoEncontrada extends RuntimeException {
    public RecompensaNoEncontrada() {
        super("Excepción: No se creó o asignó la recompensa.");
    }
}
