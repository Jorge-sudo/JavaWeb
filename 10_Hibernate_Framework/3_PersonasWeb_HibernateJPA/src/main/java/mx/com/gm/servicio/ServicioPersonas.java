package mx.com.gm.servicio;

import java.util.List;
import mx.com.gm.dao.PersonaDAO;
import mx.com.gm.domain.Persona;

public class ServicioPersonas {
    
    private PersonaDAO personaDao;
    
    public ServicioPersonas(){
        //Este constructor inicializa la variable PersonaDAO cada que se le llame 
        this.personaDao = new PersonaDAO();
    }
    
    //Metodo para listar personas
    public List<Persona> listarPersonas(){
        return this.personaDao.listar();
    }
}
