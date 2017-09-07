package dao.usuario;

import dto.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OperUsuarioIm implements OperUsuario {

    @Override
    public int insertar(Usuario dtoUsuario) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {

            try {
                PreparedStatement ps = cn.prepareStatement("insert into usuarios (nombre, apellido, nom_usuario, contrasena) values (?, ?, ?, ?)");

                ps.setString(1, dtoUsuario.getNombre());
                ps.setString(2, dtoUsuario.getApellido());
                ps.setString(3, dtoUsuario.getNom_usuario());
                ps.setString(4, dtoUsuario.getContrasena());

                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperUsuarioIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }

        return 0;
    }

    @Override
    public int modificar(Usuario dtoUsuario) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {

            try {
                PreparedStatement ps = cn.prepareStatement("update usuarios set nombre = ?, apellido = ?, nom_usuario=?, contrasena=? where id = ?");

                ps.setString(1, dtoUsuario.getNombre());
                ps.setString(2, dtoUsuario.getApellido());
                ps.setString(3, dtoUsuario.getNom_usuario());
                ps.setString(4, dtoUsuario.getContrasena());
                ps.setLong(5, dtoUsuario.getId());

                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperUsuarioIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return 0;
    }

    @Override
    public int eliminar(Usuario dtoUsuario) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("delete from usuarios where id = ?");
                ps.setLong(1, dtoUsuario.getId());

                int valor = ps.executeUpdate();

                return valor;

            } catch (SQLException ex) {
                Logger.getLogger(OperUsuarioIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return 0;
    }

    @Override
    public List<Usuario> consultar() {
        Conector con = new Conector();
        Connection cn = con.conectar();
        if (cn != null) {
            try {
                PreparedStatement ps = cn.prepareStatement("select * from usuarios");

                ResultSet rs = ps.executeQuery();

                List<Usuario> lista = new ArrayList<Usuario>();

                while (rs.next()) {

                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String nom_usuario = rs.getString("nom_usuario");
                    String contrasena = rs.getString("contrasena");

                    Usuario us = new Usuario();

                    us.setId(id);
                    us.setNombre(nombre);
                    us.setApellido(apellido);
                    us.setNom_usuario(nom_usuario);
                    us.setContrasena(contrasena);
                    lista.add(us);
                }

                return lista;

            } catch (SQLException ex) {
                Logger.getLogger(OperUsuarioIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }
        return null;
    }

    @Override
    public Usuario consultar(long pk) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {

            try {
                PreparedStatement ps = cn.prepareStatement("select * from usuarios where id = ?");
                ps.setLong(1, pk);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String nom_usuario = rs.getString("nom_usuario");
                    String contrasena = rs.getString("contrasena");

                    Usuario us = new Usuario();

                    us.setId(id);
                    us.setNombre(nombre);
                    us.setApellido(apellido);
                    us.setNom_usuario(nom_usuario);
                    us.setContrasena(contrasena);
                    return us;
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperUsuarioIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }

        }
        return null;
    }

    @Override
    public Usuario login(Usuario dtoUsuario) {
        Conector con = new Conector();
        Connection cn = con.conectar();

        if (cn != null) {

            try {
                PreparedStatement ps = cn.prepareStatement("select * from usuarios where nom_usuario = ? and contrasena = ?;");

                ps.setString(1, dtoUsuario.getNom_usuario());
                ps.setString(2, dtoUsuario.getContrasena());

//                int resp=ps.executeUpdate();

                ResultSet rs = ps.executeQuery();
                                
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String nombre = rs.getString("nombre");
                    String apellido = rs.getString("apellido");
                    String nom_usuario = rs.getString("nom_usuario");
                    String contrasena = rs.getString("contrasena");

                    Usuario us = new Usuario();

                    us.setId(id);
                    us.setNombre(nombre);
                    us.setApellido(apellido);
                    us.setNom_usuario(nom_usuario);
                    us.setContrasena(contrasena);
                    return us;
                }else{
                    Usuario us = new Usuario();
                    return us;
                }

            } catch (SQLException ex) {
                Logger.getLogger(OperUsuarioIm.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                con.desconectar(cn);
            }
        }

        return null;
    }

}
