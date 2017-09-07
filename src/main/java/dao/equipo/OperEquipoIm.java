package dao.equipo;

import dto.Equipo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexion.Conector;
import java.sql.ResultSet;
import java.util.ArrayList;

public class OperEquipoIm implements OperEquipo {

	@Override
	public int insertar(Equipo dtoE) {
		Conector con = new Conector();
		Connection cn = con.conectar();

		if (cn != null) {

			try {
				PreparedStatement ps = cn.prepareStatement("insert into equipos (nombre) values (?)");

				ps.setString(1, dtoE.getNombre());

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
	public int modificar(Equipo dtoE) {
		Conector con = new Conector();
		Connection cn = con.conectar();

		if (cn != null) {

			try {
				PreparedStatement ps = cn.prepareStatement("update equipos set nombre = ? where id = ?");
				// ps.setString(1, "Equipos");
				ps.setLong(2, dtoE.getId());
				ps.setString(1, dtoE.getNombre());

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
	public int eliminar(Equipo dtoE) {
		Conector con = new Conector();
		Connection cn = con.conectar();

		if (cn != null) {

			try {
				PreparedStatement ps = cn.prepareStatement("delete from equipos where id = ?");
				ps.setLong(1, dtoE.getId());

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
	public List<Equipo> consultar() {
		Conector con = new Conector();
		Connection cn = con.conectar();
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement("select * from equipos");

				ResultSet rs = ps.executeQuery();

				List<Equipo> lista = new ArrayList<Equipo>();

				while (rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");

					Equipo e = new Equipo();

					e.setId(id);
					e.setNombre(nombre);
					lista.add(e);
				}

				return lista;

			} catch (SQLException ex) {
				Logger.getLogger(OperEquipoIm.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				con.desconectar(cn);
			}
		}
		return null;
	}

	@Override
	public Equipo consultar(long pk) {

		Conector con = new Conector();
		Connection cn = con.conectar();

		if (cn != null) {

			try {
				PreparedStatement ps = cn.prepareStatement("select * from equipos where id = ?");
				ps.setLong(1, pk);

				ResultSet rs = ps.executeQuery();

				if (rs.next()) {
					int id = rs.getInt("id");
					String nombre = rs.getString("nombre");

					Equipo e = new Equipo();

					e.setId(id);
					e.setNombre(nombre);
					return e;
				}

			} catch (SQLException ex) {
				Logger.getLogger(OperEquipoIm.class.getName()).log(Level.SEVERE, null, ex);
			} finally {
				con.desconectar(cn);
			}

		}
		return null;
	}

}
