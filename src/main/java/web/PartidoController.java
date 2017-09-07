package web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import dto.Partido;
import dto.PartidoLocalidad;

import java.util.List;
import dao.partido.OperPartidoIm;
import dao.partido_localidad.OperPartidoLocalidadIm;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin //permite peticiones desde cualquier origen
@RestController
//@RequestMapping(path = "/admin") // This means URL's start with /demo (after Application path)
public class PartidoController {

    @RequestMapping(path = "/partido/{id}", method = RequestMethod.GET)
    public Partido consultaPartido(@PathVariable long id) {
        OperPartidoIm opPart = new OperPartidoIm();
        Partido partido = opPart.consultar(id);
        return partido;
    }

    @RequestMapping(path = "admin/partidos", method = RequestMethod.GET)
    public List<Partido> consultarPartidos() {

        OperPartidoIm oper = new OperPartidoIm();
        List<Partido> partidos = oper.consultar();

        return partidos;
    }

    @RequestMapping(path = "partidos", method = RequestMethod.GET)
    public List<Partido> consultarPartidosActivos() {

        OperPartidoIm oper = new OperPartidoIm();
        List<Partido> partidos = oper.consultarActivos();

        return partidos;
    }

    @RequestMapping(path = "admin/partido", method = RequestMethod.POST)
    public int insertarEquipo(@RequestBody Partido partido) {

        OperPartidoIm oper = new OperPartidoIm();
        int res = oper.insertar(partido);
        return res;
    }

    @RequestMapping(path = "admin/partido", method = RequestMethod.PUT)
    public int modificarPartido(@RequestBody Partido partido) {
        OperPartidoIm oper = new OperPartidoIm();
        int res = oper.modificar(partido);

        return res;
    }

    @RequestMapping(path = "admin/partido/{id}", method = RequestMethod.DELETE)
    public int eliminarPartido(@PathVariable("id") int id) {
        OperPartidoIm oper = new OperPartidoIm();
        Partido p = new Partido();
        p.setId(id);
        int rta = oper.eliminar(p);
        return rta;
    }

    /*Cambiar estado*/
    @RequestMapping(path = "admin/partido/cambiarEstado", method = RequestMethod.PUT)
    public int cambiarEstadoPartido(@RequestBody Partido partido) {
        OperPartidoIm oper = new OperPartidoIm();
        int res = oper.cambiarEstado(partido);

        return res;
    }

    //***PARTIDOS LOCALIDADES**///
    @RequestMapping(path = "/PartidosLocalidades", method = RequestMethod.GET)
    public List<PartidoLocalidad> consultarPartidosLocalidades() {

        OperPartidoLocalidadIm oper = new OperPartidoLocalidadIm();
        List<PartidoLocalidad> PartidoLocalidad = oper.consultar();

        return PartidoLocalidad;
    }

    @RequestMapping(path = "/partidoLocalidad", method = RequestMethod.POST)
    public int insertarPartidosLocalidad(@RequestBody PartidoLocalidad partidoLocalidad) {

        OperPartidoLocalidadIm oper = new OperPartidoLocalidadIm();
        int res = oper.insertar(partidoLocalidad);
        return res;
    }

    @RequestMapping(path = "/partidoLocalidades", method = RequestMethod.POST)
    public int insertarPartidosLocalidades(@RequestBody List<PartidoLocalidad> partidoLocalidades) {

        OperPartidoLocalidadIm oper = new OperPartidoLocalidadIm();
        int res = oper.insertar(partidoLocalidades);
        return res;
    }

    @RequestMapping(path = "/partidoLocalidades/{id}", method = RequestMethod.GET)
    public List<PartidoLocalidad> consultarPartidosLocalidadesId(@PathVariable int id) {
        OperPartidoLocalidadIm oper = new OperPartidoLocalidadIm();
        List<PartidoLocalidad> PartidoLocalidad = oper.consultarPorPartido(id);
        return PartidoLocalidad;
    }

}
