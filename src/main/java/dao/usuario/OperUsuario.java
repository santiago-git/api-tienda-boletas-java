package dao.usuario;

import dto.Usuario;
import java.util.List;

public interface OperUsuario {

	public int insertar(Usuario dtoUsuario);

	public int modificar(Usuario dtoUsuario);

	public int eliminar(Usuario dtoUsuario);

	public List<Usuario> consultar();

	public Usuario consultar(long pk);
        
        public Usuario login(Usuario dtoUsuario);

}