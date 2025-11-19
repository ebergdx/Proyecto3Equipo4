package recompensas;

public class CrearRecompensa {

    public static Recompensa crearRecompensa(String tipo, String nombre, int costo) {
        return new TipoRecompensa(nombre, costo, tipo);
    }
}