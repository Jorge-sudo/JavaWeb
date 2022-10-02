/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import config.Conexion;
import interfaces.ClienteInterface;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Cliente;

/**
 *
 * @author orion
 */

public class ClienteDAO implements ClienteInterface{
      Conexion cn=new Conexion();
      Connection con;
      PreparedStatement ps;
      ResultSet rs;
         

    @Override
    public List listar() {
        ArrayList<Cliente> listCliente =new ArrayList<>();
        String sql="SELECT * FROM clientes";
        try {
           con = cn.conectar();
           ps=(PreparedStatement) con.prepareStatement(sql);
           rs=ps.executeQuery();
           while(rs.next()){
               Cliente cli=new Cliente();
               cli.setId(rs.getInt(1));
               cli.setDni(rs.getString(2));
               cli.setNombres(rs.getString(3));
               listCliente.add(cli);
           }
        } catch (Exception e) {
        
        }
        return listCliente;
    }

    @Override
    public Cliente list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(Cliente cli) {
            String sql="INSERT INTO clientes(Dni, Nombres)VALUES('"+cli.getDni()+"', '"+cli.getNombres()+"')";
        try {
           con = cn.conectar();
           ps=(PreparedStatement) con.prepareStatement(sql);
           ps.executeUpdate();  
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean edit(Cliente cli) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
      
           String sql="DELETE FROM clientes WHERE Id="+id;
          try {
           con = cn.conectar();
           ps=(PreparedStatement) con.prepareStatement(sql);
           ps.executeUpdate();  
        } catch (Exception e) {
        }
        return false;
    }
    
}
