package App.Domain.Entity;

import App.Infra.Percistence.Entity.ContatoEntity;
import App.Infra.Percistence.Entity.UsuarioEntity;

import java.util.List;

public class Usuario {

    private Long id;

    private String nome;

    List<Contato> contatos;

    public Usuario() {
    }

    public Usuario(Long id, String nome, List<Contato> contatos) {
        this.id = id;
        this.nome = nome;
        this.contatos = contatos;
    }

    public Usuario(UsuarioEntity usuarioEntity) {
        this.id = usuarioEntity.getId();
        this.nome = usuarioEntity.getNome();
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

    public List<Contato> getAgenda() {
        return contatos;
    }

    public void setAgenda(List<Contato> contatoes) {
        this.contatos = contatoes;
    }
}
