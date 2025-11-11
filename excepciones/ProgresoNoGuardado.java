package excepciones;

public class ProgresoNoGuardado extends RuntimeException {
    public ProgresoNoGuardado() {
        super("Excepción: No se pudo guardar el progreso del usuario.");
    }
}
