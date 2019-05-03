package appmoviles.com.practicoexamen;

public class Votos {

    private String votoid;
    private String tipo_persona;
    private String voto;

    public Votos(String votoid, String tipo_persona, String voto) {
        this.votoid = votoid;
        this.tipo_persona = tipo_persona;
        this.voto = voto;
    }

    public Votos() {
    }

    public String getVotoid() {
        return votoid;
    }

    public void setVotoid(String votoid) {
        this.votoid = votoid;
    }

    public String getTipo_persona() {
        return tipo_persona;
    }

    public void setTipo_persona(String tipo_persona) {
        this.tipo_persona = tipo_persona;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }
}
