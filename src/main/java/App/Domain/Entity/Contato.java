package App.Domain.Entity;

import App.Infra.Percistence.Entity.ContatoEntity;

public class Contato {

    private Long id;

    private String nome;

    private Long numero;

    public Contato()
    {

    }

    public Contato(Long id, String nome, Long numero) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
    }

    public Contato(ContatoEntity contatoEntity)
    {
        this.id = contatoEntity.getId();
        this.nome = contatoEntity.getNome();
        this.numero = contatoEntity.getNumero();
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
}
