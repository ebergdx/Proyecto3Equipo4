package excepciones;

public class CorreoYaExistente extends RuntimeException {
    public CorreoYaExistente() {
        super("Excepción: El correo ya está registrado.");
    }
}