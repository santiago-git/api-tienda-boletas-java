package dao.cliente;

import conexion.Conector;
import dao.equipo.OperEquipoIm;
import dto.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class OperClienteIm implements OperCliente {

    @Override
    public int insertar(Cliente dtoC) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("insert into clientes (cc, nombre, apellido, telefono, correo, contrasena) values (?, ?, ?, ?, ?, ?)");

                ps.setLong(1, dtoC.getCc());
                ps.setString(2, dtoC.getNombre());
                ps.setString(3, dtoC.getApellido());
                ps.setString(4, dtoC.getTelefono());
                ps.setString(5, dtoC.getCorreo());
                ps.setString(6, dtoC.getContrasena());
                
                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperEquipoIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }

        }

        return 0;
    }

    @Override
    public int modificar(Cliente dtoC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Cliente dtoC) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Cliente> consultar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Cliente consultar(long pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
