package modeloDAO;

import config.Conexion;
import interfaces.ClienteInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Cliente;

/*
 * @author JORGE
 */
public class ClienteDAO implements ClienteInterface {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List<Cliente> listar() {
        
        ArrayList<Cliente> listCliente = new ArrayList<>();
        String sql = "SELECT * FROM test.clientes";
        try {
            con = Conexion.getConection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {      
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt(1));
                cliente.setDni(rs.getString(2));
                cliente.setNombre(rs.getString(3));
                listCliente.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return listCliente;
    }

    @Override
    public Cliente list(int id) {
        return null;

    }

    @Override
    public boolean add(Cliente cliente) {
        String sql = "INSERT INTO clientes(dni, nombre)VALUES('" + cliente.getDni() + "', '" + cliente.getNombre() + "')";
        try {
            con = Conexion.getConection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Cliente cliente) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM clientes WHERE idclientes=" + id;
        try {
            con = Conexion.getConection();
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

}
