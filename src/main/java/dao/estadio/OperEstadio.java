package dao.estadio;

import dto.Estadio;
import java.util.List;

public interface OperEstadio {

	public int insertar(Estadio dtoEstadio);

	public int modificar(Estadio dtoEstadio);

	public int eliminar(Estadio dtoEstadio);

	public List<Estadio> consultar();

	public Estadio consultar(long pk);

}