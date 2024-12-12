package App.Applicatoion.UseCase.Usuario;

import App.Domain.Entity.Usuario;
import App.Infra.Ports.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCaseUsuarioGet {


    private final UsuarioService usuarioService;

    public UseCaseUsuarioGet(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public ResponseEntity<List<Usuario>> ListarUsuarios()
    {return usuarioService.ListarUsuarios();}
    public ResponseEntity<Usuario> BuscarUsuarioPorId(@RequestParam Long id)
    {return usuarioService.BuscarUsuarioPorId(id);}
}
