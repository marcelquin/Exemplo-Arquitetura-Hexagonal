package App.Applicatoion.Ports.Input;

import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioDelete;
import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioGet;
import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioPost;
import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioPut;
import App.Domain.Entity.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("usuario")
@Tag(name = "usuario",
        description = "Manipula dados referente a entidade"
)
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

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/ListarUsuarios")
    public ResponseEntity<List<Usuario>> ListarUsuarios()
    {return caseUsuarioGet.ListarUsuarios();}

    @Operation(summary = "Busca Registros da tabela Por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarUsuarioPorId")
    public ResponseEntity<Usuario> BuscarUsuarioPorId(@RequestParam Long id)
    { return caseUsuarioGet.BuscarUsuarioPorId(id);}

    @Operation(summary = "Salva novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/NovoUsuario")
    public ResponseEntity<Usuario> NovoUsuario(@RequestParam String nome)
    { return caseUsuarioPost.NovoUsuario(nome);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/AdicionarContato")
    public ResponseEntity<Usuario> AdicionarContato(@RequestParam Long id,
                                                    @RequestParam String nome,
                                                    @RequestParam Long telefone)
    {return caseUsuarioPut.AdicionarContato(id, nome, telefone);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/EditarUsuario")
    public ResponseEntity<Usuario> EditarUsuario(@RequestParam Long idUsuario,
                                                 @RequestParam String nome)
    { return caseUsuarioPut.EditarUsuario(idUsuario, nome);}

    @Operation(summary = "Deleta Registro na tabela", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @DeleteMapping("/DeletarUsuarioPorId")
    public void DeletarUsuarioPorId(@RequestParam Long id)
    { caseUsuarioDelete.DeletarUsuarioPorId(id);}
}
