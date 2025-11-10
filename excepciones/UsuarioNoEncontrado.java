package excepciones;

public class UsuarioNoEncontrado extends RuntimeException {
    public UsuarioNoEncontrado() {
        super("Excepcion: No se encontró el usuario.");
    }
}