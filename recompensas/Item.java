package recompensas;

import usuarios.Cliente;

public class Item extends Recompensa {
    public Item(String nombre, int costo) {
        super(nombre, costo, "item");
    }

    @Override
    public void aplicar(Cliente cliente) {
        System.out.println("Item desbloqueao: " + nombre);
        cliente.agregarItem(nombre);
    }
}