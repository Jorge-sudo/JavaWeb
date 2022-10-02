package datos;

import dominio.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext(unitName = "PersonaPu") //Esto es el nombre de la persistencia
    EntityManager em; //Con esta clase ya podemos interactuar en nuestra base de datos 

    
    @Override
    public List<Usuario> findAllPersonas() {
        return em.createNamedQuery("Usuario.findAll").getResultList(); 
    }

    @Override
    public Usuario findUsuarioById(Usuario usuario) {
        return em.find(Usuario.class, usuario.getIdUsuario());
    }

    @Override
    public void insertUsuario(Usuario usuario) {
        em.persist(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario) {
        em.merge(usuario);
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        em.remove(em.merge(usuario));
    }
    
}
