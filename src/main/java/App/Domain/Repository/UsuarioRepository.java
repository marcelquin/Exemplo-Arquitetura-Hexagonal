package App.Domain.Repository;

import App.Domain.Entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {

    public Usuario Salvar(Usuario usuario);

    public Usuario AdicionarContato(Long idUsuario, Long idAgenda);

    public Usuario Editar(Usuario usuario);
    public Optional<Usuario> BuscarPorId(Long id);

    public List<Usuario> ListarUsuarios();

}
