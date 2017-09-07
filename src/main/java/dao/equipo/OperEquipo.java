package dao.equipo;

import dto.Equipo;
import java.util.List;

public interface OperEquipo {

	public int insertar(Equipo dtoE);

	public int modificar(Equipo dtoE);

	public int eliminar(Equipo dtoE);

	public List<Equipo> consultar();

	public Equipo consultar(long pk);

}