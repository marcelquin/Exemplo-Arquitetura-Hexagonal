package App.Applicatoion.UseCase.Usuario;

import App.Domain.Entity.Usuario;
import App.Infra.Ports.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseUsuarioPost {


    private final UsuarioService usuarioService;

    public UseCaseUsuarioPost(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    public ResponseEntity<Usuario> NovoUsuario(@RequestParam String nome)
    {return usuarioService.NovoUsuario(nome);}
}
