package App.Domain.Repository;

import App.Domain.Entity.Usuario;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository {

    public Usuario Salvar(Usuario usuario);

    public Usuario Editar(Usuario usuario);

    public Usuario Adicionar(Long idUsuario, Long idContato);
    public Optional<Usuario> BuscarPorId(Long id);

    public List<Usuario> ListarUsuarios();

    public void DeletarUsuario(Long id);

}
