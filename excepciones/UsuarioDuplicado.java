package excepciones;

public class UsuarioDuplicado extends RuntimeException {
    public UsuarioDuplicado() {
        super("Excepción: El nombre de usuario ya está registrado.");
    }
}