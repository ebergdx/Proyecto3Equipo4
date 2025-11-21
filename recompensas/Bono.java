package recompensas;

import usuarios.Cliente;

public class Bono extends Recompensa {
    public Bono(String nombre, int costo) {
        super(nombre, costo, "bono");
    }

    @Override
    public void aplicar(Cliente cliente) {
        System.out.println("Bono aplicado: +" + costo + " puntos");
        cliente.agregarPuntos(costo);
    }
}