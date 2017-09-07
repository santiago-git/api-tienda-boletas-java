package web;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.usuario.OperUsuarioIm;
import dto.Usuario;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin //permite peticiones desde cualquier origen
@RestController
@RequestMapping(path = "/admin") // This means URL's start with /demo (after Application path)
public class UsuarioController {

    @RequestMapping(path = "/usuario/{id}", method = RequestMethod.GET)
    public Usuario consultarUsuario(@PathVariable int id) {
        OperUsuarioIm opUs = new OperUsuarioIm();
        Usuario us = opUs.consultar(id);
        return us;
    }

    @RequestMapping(path = "/usuarios", method = RequestMethod.GET)
    public List<Usuario> consultarUsuarios() {

        OperUsuarioIm oper = new OperUsuarioIm();
        List<Usuario> usuarios = oper.consultar();

        return usuarios;
    }

    @RequestMapping(path = "/usuario", method = RequestMethod.POST)
    public int insertarUsuario(@RequestBody Usuario usuario) {

        OperUsuarioIm oper = new OperUsuarioIm();
        int res = oper.insertar(usuario);
        return res;
    }

    @RequestMapping(path = "/usuario", method = RequestMethod.PUT)
    public int modificartarUsuario(@RequestBody Usuario usuario) {
        OperUsuarioIm oper = new OperUsuarioIm();
        int res = oper.modificar(usuario);

        return res;
    }

    @RequestMapping(path = "/usuario/{id}", method = RequestMethod.DELETE)
    public int eliminarUsuario(@PathVariable("id") int id) {
        OperUsuarioIm oper = new OperUsuarioIm();
        Usuario us = new Usuario();
        us.setId(id);
        int rta = oper.eliminar(us);
        return rta;
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Usuario iniciarSesion(@RequestBody Usuario usuario) {

        OperUsuarioIm oper = new OperUsuarioIm();
        Usuario res = oper.login(usuario);
        return res;
    }

}
