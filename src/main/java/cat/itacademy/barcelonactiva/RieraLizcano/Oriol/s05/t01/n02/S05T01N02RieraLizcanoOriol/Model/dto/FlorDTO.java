package cat.itacademy.barcelonactiva.RieraLizcano.Oriol.s05.t01.n02.S05T01N02RieraLizcanoOriol.Model.dto;

import java.util.List;

public class FlorDTO {

    private Integer pk_FlorID;
    private String nomFlor;
    private String paisFlor;
    private String tipusFlor = "Fora UE";
    private final List<String> countriesEU = List.of("Albania","Alemania","Andorra","Armenia","Austria","Azerbaiyán","Bélgica","Bielorrusia","Bosnia y Herzegovina","Bulgaria","Chipre","Croacia","Dinamarca","Eslovaquia","Eslovenia","España","Estonia","Finlandia","Francia","Georgia","Grecia","Hungría","Irlanda","Islandia","Italia","Letonia","Liechtenstein","Lituania","Luxemburgo","Macedonia del Norte","Malta","Moldavia","Mónaco","Montenegro","Noruega","Países Bajos","Polonia","Portugal","Reino Unido","República Checa","Rumania","Rusia","San Marino","Serbia","Suecia","Suiza","Turquía","Ucrania","Vaticano");

    public FlorDTO () {}
    public FlorDTO (Integer pk_FlorID, String nomFlor, String paisFlor){
        this.pk_FlorID = pk_FlorID;
        this.nomFlor = nomFlor;
        this.paisFlor = paisFlor;
        setTipusFlor(paisFlor);
    }
    private void setTipusFlor(String paisFlor){
        if(countriesEU.stream().anyMatch(c -> c.equalsIgnoreCase(paisFlor))){
            this.tipusFlor = "UE";
        }
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
        setTipusFlor(paisFlor);
    }
    public String getTipusFlor() {
        return tipusFlor;
    }

    @Override
    public String toString() {
        return "FlorDTO{" + "pk_FlorID=" + pk_FlorID + ", nomFlor='" + nomFlor + '\'' + ", paisFlor='" + paisFlor + '\'' + ", tipusFlor='" + tipusFlor + '\'' + '}';
    }

}
