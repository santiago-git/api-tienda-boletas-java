package dto;

import java.sql.Date;

public class Partido {

    private Integer id;
    private Integer id_usuario;
    private Date fecha;
    private Integer max_cant_boletas;
    private String observaciones;
    private boolean estado;
    private Equipo DtoEquipoLocal;
    private Equipo DtoequipoVisitante;
    private Estadio dtoEstadio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getMax_cant_boletas() {
        return max_cant_boletas;
    }

    public void setMax_cant_boletas(Integer max_cant_boletas) {
        this.max_cant_boletas = max_cant_boletas;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Equipo getDtoEquipoLocal() {
        return DtoEquipoLocal;
    }

    public void setDtoEquipoLocal(Equipo DtoEquipoLocal) {
        this.DtoEquipoLocal = DtoEquipoLocal;
    }

    public Equipo getDtoequipoVisitante() {
        return DtoequipoVisitante;
    }

    public void setDtoequipoVisitante(Equipo DtoequipoVisitante) {
        this.DtoequipoVisitante = DtoequipoVisitante;
    }

    public Estadio getDtoEstadio() {
        return dtoEstadio;
    }

    public void setDtoEstadio(Estadio dtoEstadio) {
        this.dtoEstadio = dtoEstadio;
    }

    
}
