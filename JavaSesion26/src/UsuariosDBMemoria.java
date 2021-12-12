import java.util.ArrayList;

public class UsuariosDBMemoria implements UsuariosDB,UsuariosDBEstadisticas{
    private int totalEliminaciones = 0;
    private int totalInserciones = 0;
    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    public ArrayList<Usuario> obtener() {
        return usuarios;
    }

    @Override
    public Usuario buscar(Usuario usuario) {
        for(Usuario usuarioActual: usuarios) {
            if(usuarioActual.nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)){
                return usuarioActual;
            }
        }
        return null;
    }

    @Override
    public void insertar(Usuario usuario) {
        if (buscar(usuario) != null) {
            System.out.println("Este usuario ya existe en memoria. \n" + usuario);
            return;
        }
        usuarios.add(usuario);
        totalInserciones++;
    }

    @Override
    public void borrar(Usuario usuario) {
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)){
                usuarios.remove(i);
            }
        }
        totalEliminaciones++;
    }

    @Override
    public int getTotalInserciones() {
        return totalInserciones;
    }

    @Override
    public int getTotalEliminaciones() {
        return totalEliminaciones;
    }
}

