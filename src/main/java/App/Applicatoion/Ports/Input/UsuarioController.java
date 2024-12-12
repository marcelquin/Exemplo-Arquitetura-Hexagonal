package App.Applicatoion.Ports.Input;

import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioDelete;
import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioGet;
import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioPost;
import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioPut;
import App.Domain.Entity.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
public class UsuarioController {

    private final UseCaseUsuarioPut caseUsuarioPut;
    private final UseCaseUsuarioGet caseUsuarioGet;
    private final UseCaseUsuarioPost caseUsuarioPost;
    private final UseCaseUsuarioDelete caseUsuarioDelete;

    public UsuarioController(UseCaseUsuarioPut caseUsuarioPut, UseCaseUsuarioGet caseUsuarioGet, UseCaseUsuarioPost caseUsuarioPost, UseCaseUsuarioDelete caseUsuarioDelete) {
        this.caseUsuarioPut = caseUsuarioPut;
        this.caseUsuarioGet = caseUsuarioGet;
        this.caseUsuarioPost = caseUsuarioPost;
        this.caseUsuarioDelete = caseUsuarioDelete;
    }

    @GetMapping("/ListarUsuarios")
    public ResponseEntity<List<Usuario>> ListarUsuarios()
    {return caseUsuarioGet.ListarUsuarios();}

    @GetMapping("/BuscarUsuarioPorId")
    public ResponseEntity<Usuario> BuscarUsuarioPorId(@RequestParam Long id)
    { return caseUsuarioGet.BuscarUsuarioPorId(id);}

    @PostMapping("/NovoUsuario")
    public ResponseEntity<Usuario> NovoUsuario(@RequestParam String nome)
    { return caseUsuarioPost.NovoUsuario(nome);}

    @PutMapping("/AdicionarContato")
    public ResponseEntity<Usuario> AdicionarContato(@RequestParam Long id,
                                                    @RequestParam String nome,
                                                    @RequestParam Long telefone)
    {return caseUsuarioPut.AdicionarContato(id, nome, telefone);}

    @PutMapping("/EditarUsuario")
    public ResponseEntity<Usuario> EditarUsuario(@RequestParam Long idUsuario,
                                                 @RequestParam String nome)
    { return caseUsuarioPut.EditarUsuario(idUsuario, nome);}

    @DeleteMapping("/DeletarUsuarioPorId")
    public void DeletarUsuarioPorId(@RequestParam Long id)
    { caseUsuarioDelete.DeletarUsuarioPorId(id);}
}
