package mx.com._1_HolaSpring.servicio;

import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import mx.com._1_HolaSpring.dao.UsuarioDao;
import mx.com._1_HolaSpring.domain.Rol;
import mx.com._1_HolaSpring.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//Si cambialos el nombre no podra reconocer Spring y si queremos hacerlo hay que hacer unas configuraciones
@Service("userDetailsService") //este servicio lo utilizara Spring por lo tanto debe estar escrit bien 
@Slf4j          //para que pueda funcionar la seguridad de Spring debe implementar de UserDetailsService
public class UsuarioService implements UserDetailsService{
    //Injectamos la clase de usuarioDao
    @Autowired
    private UsuarioDao usuarioDao ;

    //Este metodo obtendra el objeto de Usuario filtrado por un username
    @Override
    @Transactional(readOnly = true) //transaccional solo de lectura
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //Con esto ya estamos recuperando el objeto de usuario
        Usuario usuario = usuarioDao.findByUsername(username);
        if(usuario == null){
            //si el usuario es igual a null entonces arrojamos una Exception
            throw new UsernameNotFoundException(username);
        }
        
        //Para que Spring reconoza los roles necesita un objeto de tipo  GrantedAuthority
        var roles = new ArrayList<GrantedAuthority>();//lista de roles
        
        for(Rol rol: usuario.getRoles()){
            //agregamos los roles a la lista 
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}
