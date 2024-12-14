package App.Infra.Percistence.Entity;

import App.Domain.Entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany
    List<ContatoEntity> agenda;

    public UsuarioEntity() {
    }

    public UsuarioEntity(Long id, String nome, List<ContatoEntity> agenda) {
        this.id = id;
        this.nome = nome;
        this.agenda = agenda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ContatoEntity> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<ContatoEntity> agenda) {
        this.agenda = agenda;
    }

    public UsuarioEntity(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
    }
}
