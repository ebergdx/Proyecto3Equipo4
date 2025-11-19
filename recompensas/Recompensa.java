package recompensas;

import usuarios.Cliente;
import java.io.Serializable;

public abstract class Recompensa implements Serializable {

    protected String nombre;
    protected int costo;
    protected String tipo;

    public Recompensa(String nombre, int costo, String tipo) {
        this.nombre = nombre;
        this.costo = costo;
        this.tipo = tipo;
    }

    public String getTipo() { 
        return tipo; 
    }

    public String getNombre() { 
        return nombre; 
    }

    public int getCosto() { 
        return costo; 
    }


    public void canjear(Cliente cliente) {
        aplicar(cliente);
        cliente.restarPuntos(costo);
    }

    public abstract void aplicar(Cliente cliente);
}