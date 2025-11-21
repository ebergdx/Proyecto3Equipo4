package recompensas;

public class CreadorItem extends CrearRecompensa {
    @Override
    public Recompensa crear(String nombre, int costo) {
        return new Item(nombre, costo);
    }
}