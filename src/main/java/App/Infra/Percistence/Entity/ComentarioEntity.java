package App.Infra.Percistence.Entity;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "comentario")
public class ComentarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String texto;

    public ComentarioEntity() {
    }

    public ComentarioEntity(Long id, String texto) {
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
