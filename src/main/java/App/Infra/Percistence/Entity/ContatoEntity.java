package App.Infra.Percistence.Entity;

import App.Domain.Entity.Contato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "agenda")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long numero;

    public ContatoEntity(Contato contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.numero = contato.getNumero();
    }
}
