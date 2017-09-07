package dao.partido;

import dto.Partido;
import java.util.List;

public interface OperPartido {

    public int insertar(Partido dtoPartido);

    public int modificar(Partido dtoPartido);

    public int eliminar(Partido dtoPartido);

    public List<Partido> consultar();

    public List<Partido> consultarActivos();

    public Partido consultar(long pk);

    public int cambiarEstado(Partido dtoPartido);

}
