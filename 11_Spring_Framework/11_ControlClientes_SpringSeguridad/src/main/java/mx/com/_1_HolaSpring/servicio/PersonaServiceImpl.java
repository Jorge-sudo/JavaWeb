package mx.com._1_HolaSpring.servicio;

import java.util.List;
import mx.com._1_HolaSpring.dao.PersonaDao;
import mx.com._1_HolaSpring.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/*Para que Spring pueda reconocer esta clase de servicio como parte del  contendor 
debemos hacer la siguiente anotacion */

@Service //Es importante ya que si no ponemos esta anotacion no podremos injectar esta clase 
public class PersonaServiceImpl implements PersonaService{

    //Injectamos la instancia de PersonaDao
    @Autowired //injectcion
    private PersonaDao personaDao;
    
    /*Como estaremos utilizando varias transacciones entonces para que aya commit o rolback necesitamos que 
    si todo esta bien se haga commit y si no rolback */
    
    @Override //Solo sera de tipo readOnly = solo podra leer informacion 
    @Transactional(readOnly = true) //transaccional lo ponemos por que este metodo solo leee informacion
    public List<Persona> listarPersonas() {//Este metodo no hara ni commit ni rolback 
        return (List<Persona>) personaDao.findAll();
    }

    @Override
    @Transactional //Sin ningun parametro ya que si modificara informacion en la base de datos 
    public void guardar(Persona persona) {
        personaDao.save(persona);
    }

    @Override
    @Transactional //Con esto decimos que se hara una transaccion y modificara datos de la base de datos 
    public void eliminar(Persona persona) {
        personaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true) //solo podra leer informacion y no podra modificar 
    public Persona encontrarPersona(Persona persona) {
                        //Si no encuentra la persona se regresa null como esta puesto en orElse
        return personaDao.findById(persona.getIdPersona()).orElse(null);
    }
    
}
