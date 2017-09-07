package dao.partido;

import conexion.Conector;
import dto.Ciudad;
import dto.Equipo;
import dto.Estadio;
import dto.Partido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperPartidoIm implements OperPartido {

    @Override
    public int insertar(Partido dtoPartido) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("insert into partidos (id_local, id_visitante, id_estadio, fecha, id_usuario, max_cant_boletas, observaciones, estado) values (?, ?, ?, ?, ?, ?, ?, ?)");

                ps.setInt(1, dtoPartido.getDtoEquipoLocal().getId());
                ps.setInt(2, dtoPartido.getDtoequipoVisitante().getId());
                ps.setInt(3, dtoPartido.getDtoEstadio().getId());
                ps.setDate(4, (Date) dtoPartido.getFecha());
                ps.setInt(5, dtoPartido.getId_usuario());
                ps.setInt(6, dtoPartido.getMax_cant_boletas());
                ps.setString(7, dtoPartido.getObservaciones());
                ps.setBoolean(8, dtoPartido.getEstado());

                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }

        return 0;
    }

    @Override
    public int modificar(Partido dtoPartido) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("update partidos set id_local=?, id_visitante=?, id_estadio=?, fecha=?, id_usuario=?, max_cant_boletas=?, observaciones=?, estado=? where id = ?");

                ps.setInt(9, dtoPartido.getId());
                ps.setInt(1, dtoPartido.getDtoEquipoLocal().getId());
                ps.setInt(2, dtoPartido.getDtoequipoVisitante().getId());
                ps.setInt(3, dtoPartido.getDtoEstadio().getId());
                ps.setDate(4, (Date) dtoPartido.getFecha());
                ps.setInt(5, dtoPartido.getId_usuario());
                ps.setInt(6, dtoPartido.getMax_cant_boletas());
                ps.setString(7, dtoPartido.getObservaciones());
                ps.setBoolean(8, dtoPartido.getEstado());

                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }

        return 0;
    }

    @Override
    public int eliminar(Partido dtoPartido) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("delete from partidos where id = ?");
                ps.setLong(1, dtoPartido.getId());

                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return 0;
    }

    @Override
    public List<Partido> consultar() {
        Conector con = new Conector();
        Connection cn = con.conectar();
        if (cn != null) {
            try {
                String consulta = "select p.id, e1.nombre AS equ_local, e2.nombre AS equ_visitante, est.nombre AS estadio, est.img AS img_estadio, p.fecha, p.id_usuario, p.max_cant_boletas, p.observaciones, p.estado\n"
                        + "from partidos p\n"
                        + "JOIN equipos e1 ON p.id_local=e1.id\n"
                        + "JOIN equipos e2 ON p.id_visitante=e2.id\n"
                        + "JOIN estadios est ON p.id_estadio=est.id;";

                PreparedStatement ps = cn.prepareStatement(consulta);

                ResultSet rs = ps.executeQuery();

                List<Partido> lista = new ArrayList<Partido>();

                while (rs.next()) {

                    int id = rs.getInt("id");
                    String equ_local = rs.getString("equ_local");
                    String equ_visitante = rs.getString("equ_visitante");
                    Date fecha = rs.getDate("fecha");
                    int id_usuario = rs.getInt("id_usuario");
                    int max_cant_boletas = rs.getInt("max_cant_boletas");
                    String observaciones = rs.getString("observaciones");
                    Boolean estado = rs.getBoolean("estado");
                    String estadioPartido = rs.getString("estadio");
                    String img_estadio = rs.getString("img_estadio");

                    Partido partido = new Partido();
                    Equipo equipoLocal = new Equipo();
                    Equipo equipoVisitante = new Equipo();
                    Estadio estadio = new Estadio();

                    equipoLocal.setNombre(equ_local);
                    equipoVisitante.setNombre(equ_visitante);
                    estadio.setNombre(estadioPartido);
                    estadio.setImg(img_estadio);

                    partido.setId(id);
                    partido.setDtoEquipoLocal(equipoLocal);
                    partido.setDtoequipoVisitante(equipoVisitante);
                    partido.setDtoEstadio(estadio);
                    partido.setFecha(fecha);
                    partido.setId_usuario(id_usuario);
                    partido.setMax_cant_boletas(max_cant_boletas);
                    partido.setObservaciones(observaciones);
                    partido.setEstado(estado);

                    lista.add(partido);
                }

                return lista;

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return null;
    }

    @Override
    public List<Partido> consultarActivos() {
        Conector con = new Conector();
        Connection cn = con.conectar();
        if (cn != null) {
            try {
                String consulta = "select p.id, e1.nombre AS equ_local, e2.nombre AS equ_visitante, est.nombre AS estadio, est.img AS img_estadio, p.fecha, p.id_usuario, p.max_cant_boletas, p.observaciones, p.estado\n"
                        + "from partidos p\n"
                        + "JOIN equipos e1 ON p.id_local=e1.id\n"
                        + "JOIN equipos e2 ON p.id_visitante=e2.id\n"
                        + "JOIN estadios est ON p.id_estadio=est.id\n"
                        + "WHERE p.estado=true;";

                PreparedStatement ps = cn.prepareStatement(consulta);

                ResultSet rs = ps.executeQuery();

                List<Partido> lista = new ArrayList<Partido>();

                while (rs.next()) {

                    int id = rs.getInt("id");
                    String equ_local = rs.getString("equ_local");
                    String equ_visitante = rs.getString("equ_visitante");
                    Date fecha = rs.getDate("fecha");
                    int id_usuario = rs.getInt("id_usuario");
                    int max_cant_boletas = rs.getInt("max_cant_boletas");
                    String observaciones = rs.getString("observaciones");
                    Boolean estado = rs.getBoolean("estado");
                    String estadioPartido = rs.getString("estadio");
                    String img_estadio = rs.getString("img_estadio");

                    Partido partido = new Partido();
                    Equipo equipoLocal = new Equipo();
                    Equipo equipoVisitante = new Equipo();
                    Estadio estadio = new Estadio();

                    equipoLocal.setNombre(equ_local);
                    equipoVisitante.setNombre(equ_visitante);
                    estadio.setNombre(estadioPartido);
                    estadio.setImg(img_estadio);

                    partido.setId(id);
                    partido.setDtoEquipoLocal(equipoLocal);
                    partido.setDtoequipoVisitante(equipoVisitante);
                    partido.setDtoEstadio(estadio);
                    partido.setFecha(fecha);
                    partido.setId_usuario(id_usuario);
                    partido.setMax_cant_boletas(max_cant_boletas);
                    partido.setObservaciones(observaciones);
                    partido.setEstado(estado);

                    lista.add(partido);
                }

                return lista;

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return null;
    }

    @Override
    public Partido consultar(long pk) {
        Conector con = new Conector();
        Connection cn = con.conectar();
        if (cn != null) {
            try {
                String consulta = "select p.id, e1.id AS id_equ_local, e1.nombre AS equ_local, e2.id AS id_equ_visitante, e2.nombre AS equ_visitante, est.nombre AS estadio, est.id AS id_estadio, est.img AS img_estadio, p.fecha, p.id_usuario, p.max_cant_boletas, p.observaciones, p.estado, c.nombre as nombre_ciudad\n"
                        + "from partidos p\n"
                        + "JOIN equipos e1 ON p.id_local=e1.id\n"
                        + "JOIN equipos e2 ON p.id_visitante=e2.id\n"
                        + "JOIN estadios est ON p.id_estadio=est.id\n"
                        + "JOIN ciudades c ON p.id_estadio=c.id\n"
                        + "WHERE p.id=?;";

                PreparedStatement ps = cn.prepareStatement(consulta);

                ps.setLong(1, pk);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {

                    int id = rs.getInt("id");
                    int id_equ_local = rs.getInt("id_equ_local");
                    String equ_local = rs.getString("equ_local");
                    int id_equ_visitante = rs.getInt("id_equ_visitante");
                    String equ_visitante = rs.getString("equ_visitante");
                    Date fecha = rs.getDate("fecha");
                    int id_usuario = rs.getInt("id_usuario");
                    int max_cant_boletas = rs.getInt("max_cant_boletas");
                    String observaciones = rs.getString("observaciones");
                    Boolean estado = rs.getBoolean("estado");
                    int id_estadio = rs.getInt("id_estadio");
                    String estadioPartido = rs.getString("estadio");
                    String img_estadio = rs.getString("img_estadio");
                    String nombre_ciudad = rs.getString("nombre_ciudad");

                    Partido partido = new Partido();
                    Equipo equipoLocal = new Equipo();
                    Equipo equipoVisitante = new Equipo();
                    Estadio estadio = new Estadio();

                    equipoLocal.setId(id_equ_local);
                    equipoLocal.setNombre(equ_local);
                    equipoVisitante.setId(id_equ_visitante);
                    equipoVisitante.setNombre(equ_visitante);
                    estadio.setId(id_estadio);
                    estadio.setNombre(estadioPartido);
                    estadio.setImg(img_estadio);

                    Ciudad c = new Ciudad();
                    c.setId(id_estadio);
                    c.setNombre(nombre_ciudad);

                    estadio.setCiudad(c);

                    partido.setId(id);
                    partido.setDtoEquipoLocal(equipoLocal);
                    partido.setDtoequipoVisitante(equipoVisitante);
                    partido.setDtoEstadio(estadio);
                    partido.setFecha(fecha);
                    partido.setId_usuario(id_usuario);
                    partido.setMax_cant_boletas(max_cant_boletas);
                    partido.setObservaciones(observaciones);
                    partido.setEstado(estado);

                    return partido;
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return null;
    }

    @Override
    public int cambiarEstado(Partido dtoPartido) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {

            try {
                PreparedStatement ps = cn.prepareStatement("update partidos set estado = ? where id = ?");

                ps.setBoolean(1, dtoPartido.getEstado());
                ps.setInt(2, dtoPartido.getId());

                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperPartidoIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return 0;
    }

}
