package usuarios;

public abstract class Usuario {
    protected String nombre;
    protected String email;
    protected int id;
    protected boolean sesion = false;

    protected Usuario(String nombre, String email, int id) {
        this.nombre = nombre;
        this.email = email;
        this.id = id;
    }

    public void iniciarSesion() {
        this.sesion = true;
    }

    public void cerrarSesion() {
        this.sesion = false;
    }

    public String getNombre() {
        return nombre;
    }
    
    public String getEmail() {
        return email;
    }
    
    public int getId() {
        return id;
    }
    
    public boolean SesionActiva() {
        return sesion;
    }
}