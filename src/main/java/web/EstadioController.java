package web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dao.estadio.OperEstadioIm;
import dto.Estadio;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RestController
@RequestMapping(path = "/admin") // This means URL's start with /demo (after Application path)
public class EstadioController {

    @RequestMapping(path = "/estadios", method = RequestMethod.GET)
    public List<Estadio> consultarEstadios() {

        OperEstadioIm oper = new OperEstadioIm();
        List<Estadio> estadios = oper.consultar();

        return estadios;
    }
}
