package usuarios;

public class Admin extends Usuario {
    private int clave;

    public Admin(String nombre, String email, String password, int clave) {
        super(nombre, email, password);
        this.clave = clave;
    }

    public int getClave() {
        return clave;
    }
}