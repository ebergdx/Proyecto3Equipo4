package excepciones;

public class HabitoNoEncontrado extends RuntimeException {
    public HabitoNoEncontrado() {
        super("Excepción: No se encontró el hábito seleccionado.");
    }
}