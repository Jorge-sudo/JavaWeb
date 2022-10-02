/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;
import modelos.Cliente;

/**
 *
 * @author orion
 */
public interface ClienteInterface {
       public List listar();
       public Cliente list(int id);
       public boolean add(Cliente cli);
       public boolean edit(Cliente cli);
       public boolean delete(int id);
}
