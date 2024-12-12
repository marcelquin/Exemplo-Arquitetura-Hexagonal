package App.Domain.Repository;

import App.Domain.Entity.Contato;

import java.util.Optional;

public interface ContatoRepository {

    public Contato Salvar(Contato contato);

    public Contato Editar(Contato contato);
    public Optional<Contato> BuscarPorId(Long id);


}
