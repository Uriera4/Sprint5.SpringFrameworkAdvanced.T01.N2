package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "flors")
public class FlorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pk_FlorID;
    @Column(name="nom")
    private String nomFlor;
    @Column(name="pais")
    private String paisFlor;

    public FlorEntity (){}
    public FlorEntity (String nomFlor, String paisFlor){
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
    }

    public Integer getPk_FlorID() {
        return pk_FlorID;
    }
    public void setPk_FlorID(Integer pk_FlorID) {
        this.pk_FlorID = pk_FlorID;
    }
    public String getNomFlor() {
        return nomFlor;
    }
    public void setNomFlor(String nomFlor) {
        this.nomFlor = nomFlor;
    }
    public String getPaisFlor() {
        return paisFlor;
    }
    public void setPaisFlor(String paisFlor) {
        this.paisFlor = paisFlor;
    }

    @Override
    public String toString() {
        return "FlorEntity{" + "pk_FlorID=" + pk_FlorID + ", nomFlor='" + nomFlor + '\'' + ", paisFlor='" + paisFlor + '\'' + '}';
    }
}
