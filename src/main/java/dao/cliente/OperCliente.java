package dao.cliente;

import dto.Cliente;
import java.util.List;

public interface OperCliente {

	public int insertar(Cliente dtoC);

	public int modificar(Cliente dtoC);

	public int eliminar(Cliente dtoC);

	public List<Cliente> consultar();

	public Cliente consultar(long pk);

}