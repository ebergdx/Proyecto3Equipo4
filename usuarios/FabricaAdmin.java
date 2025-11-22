package usuarios;

public class FabricaAdmin extends UsuarioFabAbs {
    @Override
    public Usuario crearUsuario(String nombre, String email, String password, String extra) {
        return new Admin(nombre, email, password, extra);
    }
}