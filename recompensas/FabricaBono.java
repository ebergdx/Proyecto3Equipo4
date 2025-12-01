package recompensas;

public class FabricaBono implements FabAbsRecompensa {
    @Override
    public Recompensa crear(String nombre, int costo) {
        return new Bono(nombre, costo);
    }
}