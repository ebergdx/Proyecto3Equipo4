package usuarios;

public class Admin extends Usuario {
    private short clave;

    public Admin(String nombre, String email, int id, short clave) {
        super(nombre, email, id);
        this.clave = clave;
    }
}
