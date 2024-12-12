package App.Applicatoion.UseCase.Usuario;

import App.Domain.Entity.Usuario;
import App.Infra.Ports.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseUsuarioPut {


    private final UsuarioService usuarioService;

    public UseCaseUsuarioPut(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public ResponseEntity<Usuario> AdicionarContato(@RequestParam Long id,
                                                    @RequestParam String nome,
                                                    @RequestParam Long telegone)
    {return usuarioService.AdicionarContato(id, nome, telegone);}


    public ResponseEntity<Usuario> EditarUsuario(@RequestParam Long idUsuario,
                                                 @RequestParam String nome)
    {return usuarioService.EditarUsuario(idUsuario, nome);}
}
