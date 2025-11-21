package recompensas;

import usuarios.Cliente;

public class Logro extends Recompensa {
    public Logro(String nombre, int costo) {
        super(nombre, costo, "logro");
    }

    @Override
    public void aplicar(Cliente cliente) {
        System.out.println("Logro desbloqueado: " + nombre);
        cliente.agregarLogro(nombre);
    }
}