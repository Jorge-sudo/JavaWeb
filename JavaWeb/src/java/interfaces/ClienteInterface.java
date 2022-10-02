
package interfaces;

import java.util.List;
import modelos.Cliente;
/*
 * @author JORGE
 */
public interface ClienteInterface {
    public List<Cliente> listar();
    public Cliente list(int id);
    public boolean add(Cliente cliente);
    public boolean edit(Cliente cliente);
    public boolean delete(int id);
}
