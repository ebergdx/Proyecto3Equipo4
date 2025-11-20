package recompensas;

import usuarios.Cliente;

public class TipoRecompensa extends Recompensa {

    public TipoRecompensa(String nombre, int costo, String tipo) {
        super(nombre, costo, tipo);
    }

    @Override
    public void aplicar(Cliente cliente) {

        switch(tipo) {

            case "logro":
                System.out.println("Logro desbloqueado: ");
                cliente.agregarLogro(nombre);
                break;

            case "item":
                System.out.println("Item agregado: ");
                cliente.agregarItem(nombre);
                break;

            case "bono":
                System.out.println("Bono de: +" + costo + " puntos");
                cliente.agregarPuntos(costo);
                break;

            default:
                System.out.println("Esa recompensa no existe :(");
        }
    }
}