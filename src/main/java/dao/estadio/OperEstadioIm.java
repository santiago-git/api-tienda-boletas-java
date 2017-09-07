package dao.estadio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexion.Conector;
import dao.estadio.OperEstadio;
import dto.Ciudad;
import dto.Estadio;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OperEstadioIm implements OperEstadio {

    @Override
    public int insertar(Estadio dtoEstadio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int modificar(Estadio dtoEstadio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(Estadio dtoEstadio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estadio> consultar() {
        Conector con = new Conector();
        Connection cn = con.conectar();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("select * from estadios");

                ResultSet rs = ps.executeQuery();

                List<Estadio> lista = new ArrayList<Estadio>();

                while (rs.next()) {

                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String imagen = rs.getString("img");
                    int id_ciudad = rs.getInt("id_ciudad");

                    Estadio est = new Estadio();

                    est.setId(id);
                    est.setNombre(nombre);
                    est.setImg(imagen);
                    
                    Ciudad c=new Ciudad();
                    c.setId(id_ciudad);
                    est.setCiudad(c);
                    
                    lista.add(est);
                }

                return lista;

            } catch (SQLException ex) {
                Logger.getLogger(OperEstadioIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return null;
    }

    @Override
    public Estadio consultar(long pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
