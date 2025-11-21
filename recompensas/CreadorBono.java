package recompensas;

public class CreadorBono extends CrearRecompensa {
    @Override
    public Recompensa crear(String nombre, int costo) {
        return new Bono(nombre, costo);
    }
}