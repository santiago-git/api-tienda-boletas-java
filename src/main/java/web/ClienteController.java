package web;

import dao.cliente.OperClienteIm;
import dto.Cliente;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
public class ClienteController {

//    @RequestMapping(path = "/equipo/{id}", method = RequestMethod.GET)
//    public Equipo consultarEquipo(@PathVariable int id) {
//        OperEquipoIm opEq = new OperEquipoIm();
//        Equipo eq = opEq.consultar(id);
//        return eq;
//    }

//    @RequestMapping(path = "/equipos", method = RequestMethod.GET)
//    public List<Equipo> consultarEquipos() {
//
//        OperEquipoIm oper = new OperEquipoIm();
//        List<Equipo> equipos = oper.consultar();
//
//        return equipos;
//    }

    @RequestMapping(path = "/cliente", method = RequestMethod.POST)
    public int insertarCliente(@RequestBody Cliente cliente) {
        OperClienteIm oper = new OperClienteIm();
        int res = oper.insertar(cliente);
        return res;
    }
//
//    @RequestMapping(path = "/equipo", method = RequestMethod.PUT)
//    public int modificartarEquipo(@RequestBody Equipo equipo) {
//        OperEquipoIm oper = new OperEquipoIm();
//        int res = oper.modificar(equipo);
//
//        return res;
//    }
//
//    @RequestMapping(path = "/equipo/{id}", method = RequestMethod.DELETE)
//    public int eliminarEquipo(@PathVariable("id") int id) {
//        OperEquipoIm oper = new OperEquipoIm();
//        Equipo e = new Equipo();
//        e.setId(id);
//        int rta = oper.eliminar(e);
//        return rta;
//    }

}
