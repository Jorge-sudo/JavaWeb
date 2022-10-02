package datos;

import dominio.Usuario;
import java.util.List;

public interface UsuarioDao {
    
    public List<Usuario> findAllPersonas();
    
    public Usuario findUsuarioById(Usuario usuario);
    
    public void insertUsuario(Usuario usuario);
    
    public void updateUsuario(Usuario usuario);
    
    public void deleteUsuario(Usuario usuario);
}
