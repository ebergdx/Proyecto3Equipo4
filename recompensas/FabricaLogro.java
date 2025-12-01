package recompensas;

public class FabricaLogro implements FabAbsRecompensa {
    @Override
    public Recompensa crear(String nombre, int costo) {
        return new Logro(nombre, costo);
    }
}