package usuarios;

public class Admin extends Usuario {
    private String clave;

    public Admin(String nombre, String email, String password, String clave) {
        super(nombre, email, password);
        this.clave = clave;
    }

    public String getClave() {
        return clave;
    }
}