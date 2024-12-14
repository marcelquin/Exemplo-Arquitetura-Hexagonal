package App.Infra.Percistence.Entity;

import App.Domain.Entity.Contato;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "contato")
public class ContatoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Long numero;


    public ContatoEntity() {
    }

    public ContatoEntity(Long id, String nome, Long numero) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
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

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public ContatoEntity(Contato contato) {
        this.id = contato.getId();
        this.nome = contato.getNome();
        this.numero = contato.getNumero();
    }
}
