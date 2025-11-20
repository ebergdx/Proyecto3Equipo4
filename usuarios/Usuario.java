package usuarios;

import java.io.Serializable;

public abstract class Usuario implements Serializable {
    protected String nombre;
    protected String email;
    protected String password;
    protected boolean sesion = false;

    protected Usuario(String nombre, String email, String password) {
        this.nombre = nombre;
        this.email = email;
        this.password = password;
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
        return this.email;
    }

    public String getPassword() {
        return password;
    }
}