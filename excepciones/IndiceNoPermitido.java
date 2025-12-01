package excepciones;

public class IndiceNoPermitido extends RuntimeException {
    public IndiceNoPermitido() {
        super("Excepción: ïndice fuera del rango.");
    }
}
