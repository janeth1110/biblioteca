package Logica;

import AccesoDatos.Login;
import java.util.ArrayList;
import java.util.List;

public class AdministrarUsuario {

    Login login = new Login();
    Usuario user = new Usuario();

    /**
     * Crea nuevo usuario
     *
     * @param user
     * @return true/false
     */
    public boolean agregarAutor(Usuario user) {
        return login.agregarUsuario(user.getId(), user.getPass(), user.getNames(), user.getLastNames(), user.getRol());
    }

    /**
     * Obtiene usuario para inicio de sesion
     *
     * @param userId
     * @return Usuario
     */
    public Usuario obtenerUsuario(int userId) {
        user = login.obtenerUsuario(userId);
        return user;
    }

    /**
     * modifica contraseña de un usuario
     *
     * @param id
     * @param pass
     * @return valores a modificar del usuario
     */
    public boolean modificarUsuario(int id, String pass) {
        return login.modificarUsuario(id, pass);
    }

    /**
     * Muestra lista de usuarios inscritos para hacer uso de la aplicacion
     *
     * @return lista de usuarios
     */
    public List<Usuario> mostrarUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios = login.mostrarUsuario();
        return listaUsuarios;
    }

    /**
     * Metodo para eliminar usuarios
     *
     * @param id
     * @return id del usuario a eliminar
     */
    public boolean eliminarUsuario(int id) {
        return login.eliminarUsuario(id);
    }

}
