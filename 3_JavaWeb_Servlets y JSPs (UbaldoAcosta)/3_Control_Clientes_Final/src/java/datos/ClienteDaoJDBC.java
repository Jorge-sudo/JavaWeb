package datos;

import dominio.Cliente;
import java.sql.*;
import java.util.*;

public class ClienteDaoJDBC {

    private static final String SQL_SELECT = "SELECT id_cliente, nombre, apellido, email, telefono, saldo "
            + "FROM cliente";
    private static final String SQL_SELECT_BY_ID = "SELECT id_cliente, nombre, apellido, email, telefono, saldo "
            + "FROM cliente WHERE id_cliente = ?";
    private static final String SQL_INSERT = "INSERT INTO cliente(nombre, apellido, email, telefono, saldo) "
            + "VALUES(?, ?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE cliente "
            + "SET nombre = ?, apellido = ?, email = ?, telefono = ?, saldo = ? WHERE id_cliente = ?";
    private static final String SQL_DELETE = "DELETE FROM cliente WHERE id_cliente=?";

    public List<Cliente> listar() {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        List<Cliente> clientes = new ArrayList<>();
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_cliente = rs.getInt(1);
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String email = rs.getString(4);
                String telefono = rs.getString(5);
                double saldo = rs.getDouble(6);

                cliente = new Cliente(id_cliente, nombre, apellido, email, telefono, saldo);
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }

        return clientes;
    }

    public Cliente encontrar(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getIdCliente());
            rs = stmt.executeQuery();
            //nos posicionamos en el primer registro esto ponemos por que ya no necesitamos el metodo rs.next()
            //rs.absolute(1);
            if (rs.next()) {
                String nombre = rs.getString(2);
                String apellido = rs.getString(3);
                String email = rs.getString(4);
                String telefono = rs.getString(5);
                double saldo = rs.getDouble(6);

                cliente.setNombre(nombre);
                cliente.setApellido(apellido);
                cliente.setEmail(email);
                cliente.setTelefono(telefono);
                cliente.setSaldo(saldo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return cliente;
    }

    public int insertar(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int contador = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_INSERT);
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());

            contador = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return contador;
    }

    public int actualizar(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int contador = 0;
        try {
            con = Conexion.getConnection();
//            stmt = con.prepareStatement("UPDATE cliente"
//                    + "SET nombre = '" + cliente.getNombre() + "', apellido = '" + cliente.getApellido() + "', "
//                    + "email = '" + cliente.getEmail() + "', telefono = '" + cliente.getTelefono() + "',"
//                    + " saldo = "+cliente.getSaldo()+" WHERE id_cliente = "+cliente.getIdCliente()+";");

            stmt = con.prepareStatement(SQL_UPDATE);
            
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getApellido());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getIdCliente());
            
            contador = stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("ex = " + ex);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return contador;
    }

    public int eliminar(Cliente cliente) {
        Connection con = null;
        PreparedStatement stmt = null;
        int contador = 0;
        try {
            con = Conexion.getConnection();
            stmt = con.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cliente.getIdCliente());

            contador = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(con);
        }
        return contador;
    }
}
