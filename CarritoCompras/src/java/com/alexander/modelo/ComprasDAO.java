package com.alexander.modelo;

import com.alexander.config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ComprasDAO {

    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

    public int IdCompra() {
        int idc = 0;
        String sql = "SELECT MAX(idCompras) FROM bdcarritocompras.compras";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idc = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return idc;
    }

    public int guardarCompra(Compra co) {
        String sql = "INSERT INTO bdcarritocompras.compras(idCliente,idPago, FechaCompras,Monto,Estado)values(?,?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, co.getIdCliente());
            ps.setInt(2, co.getIdPago());
            ps.setString(3, co.getFecha());
            ps.setDouble(4, co.getMonto());
            ps.setString(5, co.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }

    public int guardarDetalleCompra(DetalleCompra dc) {
        String sql = "INSERT INTO bdcarritocompras.detalle_Compras(idProducto,idCompras, Cantidad, PrecioCompra)VALUES(?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dc.getIdproducto());
            ps.setInt(2, dc.getIdcompra());
            ps.setInt(3, dc.getCantidad());
            ps.setDouble(4, dc.getPrecioCompra());
            ps.executeUpdate();
            con.close();
        } catch (Exception e) {
        }
        return 1;
    }

    public List misCompras(int id) {
        List lista = new ArrayList();
        String sql = "SELECT * from bdcarritocompras.compras WHERE idCliente=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Compra com = new Compra();
                com.setId(rs.getInt(1));
                com.setIdCliente(rs.getInt(2));
                com.setIdPago(rs.getInt(3));
                com.setFecha(rs.getString(4));
                com.setMonto(rs.getDouble(5));
                com.setEstado(rs.getString(6));
                lista.add(com);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public List Detalle(int id) {
        List lista = new ArrayList();
        String sql = "SELECT DC.idDetalle, P.Foto, P.Nombres, DC.idCompras, DC.Cantidad, DC.PrecioCompra FROM bdcarritocompras.detalle_compras DC INNER JOIN bdcarritocompras.producto P on P.idProducto = DC.idProducto WHERE idCompras=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleCompra dcom = new DetalleCompra();
                dcom.setId(rs.getInt(1));
                dcom.setProducto(new Producto());
                dcom.getProducto().setImagen(rs.getString(2));
                dcom.getProducto().setNombres(rs.getString(3));
                dcom.setIdcompra(rs.getInt(4));
                dcom.setCantidad(rs.getInt(5));
                dcom.setPrecioCompra(rs.getDouble(6));
                lista.add(dcom);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int Pagar(double monto) {
        String sql = "INSERT INTO bdcarritocompras.pago(Monto)VALUES(?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setDouble(1, monto);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return 1;
    }

    public int IdPago() {
        int idpago = 0;
        String sql = "SELECT MAX(idPago) FORM bdcarritocompras.pago";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idpago = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return idpago;
    }
}
