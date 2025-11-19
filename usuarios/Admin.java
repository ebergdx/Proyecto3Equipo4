package usuarios;

public class Admin extends Usuario {
    private short clave;

    public Admin(String nombre, String email, int password, short clave) {
        super(nombre, email, password);
        this.clave = clave;
    }

    public short getClave() {
        return clave;
    }
}
