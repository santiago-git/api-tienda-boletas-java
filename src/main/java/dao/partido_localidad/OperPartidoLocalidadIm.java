package dao.partido_localidad;

import conexion.Conector;
import dto.Localidad;
import dto.PartidoLocalidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperPartidoLocalidadIm implements OperPartidoLocalidad {

    @Override
    public int insertar(PartidoLocalidad dtoPartidoLocalidad) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {

            try {
                PreparedStatement ps = cn.prepareStatement("insert into partidos_localidades (id_partido, id_localidad, num_boletas, precio) values (?, ?, ?, ?)");

                ps.setInt(1, dtoPartidoLocalidad.getId_partido());
                ps.setInt(2, dtoPartidoLocalidad.getId_localidad());
                ps.setInt(3, dtoPartidoLocalidad.getNum_boletas());
                ps.setFloat(4, dtoPartidoLocalidad.getPrecio());

                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoLocalidadIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }

        return 0;
    }

    @Override
    public int insertar(List<PartidoLocalidad> dtoPartidoLocalidades) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {

            try {
                String consulta = "insert into partidos_localidades (id_partido, id_localidad, num_boletas, precio) values (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?), (?, ?, ?, ?)";
                PreparedStatement ps = cn.prepareStatement(consulta);

                int num = 1;
                for (PartidoLocalidad pl : dtoPartidoLocalidades) {
                    ps.setInt(num++, pl.getId_partido());
                    ps.setInt(num++, pl.getId_localidad());
                    ps.setInt(num++, pl.getNum_boletas());
                    ps.setFloat(num++, pl.getPrecio());
                }

                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoLocalidadIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }

        return 0;
    }

    @Override
    public int modificar(PartidoLocalidad dtoPartidoLocalidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int eliminar(PartidoLocalidad dtoPartidoLocalidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PartidoLocalidad> consultar() {
        Conector con = new Conector();
        Connection cn = con.conectar();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("select * from partidos_localidades");
                ResultSet rs = ps.executeQuery();
                List<PartidoLocalidad> lista = new ArrayList<PartidoLocalidad>();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int id_partido = rs.getInt("id_partido");
                    int id_localidad = rs.getInt("id_localidad");
                    int num_boletas = rs.getInt("num_boletas");
                    Float precio = rs.getFloat("precio");

                    PartidoLocalidad pl = new PartidoLocalidad();

                    pl.setId(id);
                    pl.setId_partido(id_partido);
                    pl.setNum_boletas(num_boletas);
                    pl.setPrecio(precio);
                    
                    Localidad l=new Localidad();
                    l.setId(id_localidad);
                    
                    pl.setLocalidad(l);
                    
                    lista.add(pl);
                }

                return lista;
            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoLocalidadIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return null;
    }

    @Override
    public PartidoLocalidad consultar(long pk) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PartidoLocalidad> consultarPorPartido(long idPartido) {
        Conector con = new Conector();
        Connection cn = con.conectar();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("select pl.id, pl.id_partido, pl.num_boletas, pl.precio, l.id as id_localidad, l.nombre as nombre_localidad from partidos_localidades pl\n"
                        + "join localidades l ON pl.id_localidad=l.id\n"
                        + "where pl.id_partido=?;");
                ps.setLong(1, idPartido);

                ResultSet rs = ps.executeQuery();
                List<PartidoLocalidad> lista = new ArrayList<PartidoLocalidad>();

                while (rs.next()) {
                    int id = rs.getInt("id");
                    int id_partido = rs.getInt("id_partido");
                    int id_localidad = rs.getInt("id_localidad");
                    String nombre_localidad = rs.getString("nombre_localidad");
                    int num_boletas = rs.getInt("num_boletas");
                    Float precio = rs.getFloat("precio");

                    PartidoLocalidad pl = new PartidoLocalidad();

                    pl.setId(id);
                    pl.setId_partido(id_partido);
                    pl.setNum_boletas(num_boletas);
                    pl.setPrecio(precio);
                    
                    Localidad l=new Localidad();
                    l.setId(id_localidad);
                    l.setNombre(nombre_localidad);
                    
                    pl.setLocalidad(l);
                    pl.setId_localidad(id_localidad);
                    
                    lista.add(pl);
                }

                return lista;

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoLocalidadIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return null;
    }

}
