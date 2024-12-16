package App.Domain.Entity;

import java.util.List;

public class PostagemResponse {

    private Long id;
    private String titulo;

    private String conteudo;

    private List<ComentarioResponse> comentarios;

    public PostagemResponse() {
    }

    public PostagemResponse(Long id, String titulo, String conteudo, List<ComentarioResponse> comentarios) {
        this.id = id;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.comentarios = comentarios;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public List<ComentarioResponse> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<ComentarioResponse> comentarios) {
        this.comentarios = comentarios;
    }

}
