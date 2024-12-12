package App.Infra.Ports;

import App.Domain.Entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UsuarioService {

    public ResponseEntity<List<Usuario>> ListarUsuarios();
    public ResponseEntity<Usuario> BuscarUsuarioPorId(@RequestParam Long id);

    public ResponseEntity<Usuario> NovoUsuario(@RequestParam String nome);

    public ResponseEntity<Usuario> AdicionarContato(@RequestParam Long id,
                                                    @RequestParam String nome,
                                                    @RequestParam Long telefone)  ;


    public ResponseEntity<Usuario> EditarUsuario(@RequestParam Long idUsuario,
                                                 @RequestParam String nome);


    public void DeletarUsuarioPorId(@RequestParam Long id);
}
