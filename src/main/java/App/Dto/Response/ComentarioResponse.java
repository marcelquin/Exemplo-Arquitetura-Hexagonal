package App.Dto.Response;

public class ComentarioResponse {

    private Long id;

    private String texto;

    public ComentarioResponse() {
    }

    public ComentarioResponse(Long id, String texto) {
        this.id = id;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
