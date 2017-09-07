package dao.partido_localidad;

import dto.PartidoLocalidad;
import java.util.List;

public interface OperPartidoLocalidad {

    public int insertar(PartidoLocalidad dtoPartidoLocalidad);

    public int insertar(List<PartidoLocalidad> dtoPartidoLocalidades);

    public int modificar(PartidoLocalidad dtoPartidoLocalidad);

    public int eliminar(PartidoLocalidad dtoPartidoLocalidad);

    public List<PartidoLocalidad> consultar();

    public List<PartidoLocalidad> consultarPorPartido(long idPartido);

    public PartidoLocalidad consultar(long pk);

}
