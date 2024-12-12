package App.Applicatoion.UseCase.Usuario;

import App.Domain.Entity.Usuario;
import App.Infra.Ports.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseUsuarioDelete {


    private final UsuarioService usuarioService;

    public UseCaseUsuarioDelete(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void DeletarUsuarioPorId(@RequestParam Long id)
    {usuarioService.DeletarUsuarioPorId(id); }
}
