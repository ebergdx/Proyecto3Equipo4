package recompensas;

public class CreadorLogro extends CrearRecompensa {
    @Override
    public Recompensa crear(String nombre, int costo) {
        return new Logro(nombre, costo);
    }
}