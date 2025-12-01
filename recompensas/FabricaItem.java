package recompensas;

public class FabricaItem implements FabAbsRecompensa {
    @Override
    public Recompensa crear(String nombre, int costo) {
        return new Item(nombre, costo);
    }
}