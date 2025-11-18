package usuarios;

import java.io.Serializable;

public class Admin extends Usuario implements Serializable {
    private short clave;
    
    public Admin(String nombre, String email, int id, short clave) {
        super(nombre, email, id);
        this.clave = clave;
    }
    
    public short getClave() {
        return clave;
    }
}
