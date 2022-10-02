package mx.com.gm.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity//la anotacion de entidad
public class Domicilio implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Tipo de llave primmaria con esto formalizamos la llave primaria 
    @Column(name = "id_domicilio")
    private Integer idDomicilio;//int/Integer es igual pero es recomendado Integer

    private String calle;

    @Column(name = "nro_calle")
    private String nroCalle;

    private String pais;

    //El constructor es para cumplir el javaBean ya que estas clases tammbien deben cumplirlas 
    public Domicilio() {

    }
    //Este constructor para idDomicilio
    public Domicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public Integer getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(Integer idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoCalle() {
        return nroCalle;
    }

    public void setNoCalle(String noCalle) {
        this.nroCalle = noCalle;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    //ToString para visualizar nuestros datos 
    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", noCalle=" + nroCalle + ", pais=" + pais + '}';
    }

    //Como buena practica tambien generamos equals y hashCode son metodos para saber si 2 objetos son iguales 
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.idDomicilio);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Domicilio other = (Domicilio) obj;
        if (!Objects.equals(this.idDomicilio, other.idDomicilio)) {
            return false;
        }
        return true;
    }

}
