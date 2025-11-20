package excepciones;

public class UsuarioNoEncontrado extends RuntimeException {
    public UsuarioNoEncontrado() {
        super("Excepción: No se encontró el usuario.");
    }
}