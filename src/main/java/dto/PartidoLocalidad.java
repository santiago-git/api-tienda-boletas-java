package dto;

public class PartidoLocalidad {

    private Integer id;
    private Integer id_partido;
    private Integer id_localidad;
    private Localidad localidad;
    private Integer num_boletas;
    private Float precio;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_partido() {
        return id_partido;
    }

    public void setId_partido(Integer id_partido) {
        this.id_partido = id_partido;
    }

    public Integer getId_localidad() {
        return id_localidad;
    }

    public void setId_localidad(Integer id_localidad) {
        this.id_localidad = id_localidad;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public Integer getNum_boletas() {
        return num_boletas;
    }

    public void setNum_boletas(Integer num_boletas) {
        this.num_boletas = num_boletas;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }


}