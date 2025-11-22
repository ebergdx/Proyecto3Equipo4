package usuarios;

public class FabricaCliente extends UsuarioFabAbs {
    @Override
    public Usuario crearUsuario(String nombre, String email, String password, String extra) {
        return new Cliente(nombre, email, password, extra);
    }
}