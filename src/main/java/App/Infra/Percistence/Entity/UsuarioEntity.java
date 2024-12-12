package App.Infra.Percistence.Entity;

import App.Domain.Entity.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "agenda")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany
    List<ContatoEntity> agenda;

    public UsuarioEntity(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.agenda = usuario.getAgenda();
    }
}
