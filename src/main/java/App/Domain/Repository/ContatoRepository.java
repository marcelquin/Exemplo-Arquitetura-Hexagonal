package App.Domain.Repository;

import App.Domain.Entity.Contato;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContatoRepository {

    public Contato Salvar(Contato contato);

    public Contato Editar(Contato contato);
    public Optional<Contato> BuscarPorId(Long id);
    public void DeletarContato(Long id);


}
