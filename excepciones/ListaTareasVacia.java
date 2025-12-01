package excepciones;

public class ListaTareasVacia extends RuntimeException {
    public ListaTareasVacia() {
        super("Excepción: Lista de tareas.");
    }
}