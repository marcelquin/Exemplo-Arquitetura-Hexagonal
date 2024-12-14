package App.Applicatoion.Ports.Input;

import App.Applicatoion.UseCase.Contato.UseCaseContatoDelete;
import App.Applicatoion.UseCase.Contato.UseCaseContatoGet;
import App.Applicatoion.UseCase.Contato.UseCaseContatoPost;
import App.Applicatoion.UseCase.Contato.UseCaseContatoPut;
import App.Domain.Entity.Contato;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Contato")
@RestController
@Tag(name = "Contato",
        description = "Manipula dados referente a entidade"
)
public class ContatoController {

    private final UseCaseContatoDelete caseContatoDelete;
    private final UseCaseContatoPost caseContatoPost;
    private final UseCaseContatoGet caseContatoGet;
    private final UseCaseContatoPut caseContatoPut;

    public ContatoController(UseCaseContatoDelete caseContatoDelete, UseCaseContatoPost caseContatoPost, UseCaseContatoGet caseContatoGet, UseCaseContatoPut caseContatoPut) {
        this.caseContatoDelete = caseContatoDelete;
        this.caseContatoPost = caseContatoPost;
        this.caseContatoGet = caseContatoGet;
        this.caseContatoPut = caseContatoPut;
    }

    @Operation(summary = "Lista Registros da tabela", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/LocalizarContatoPorId")
    public ResponseEntity<Contato> LocalizarContatoPorId(@RequestParam Long id)
    {return caseContatoGet.LocalizarContatoPorId(id);}

    @Operation(summary = "Salva novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/NovoContato")
    public ResponseEntity<Contato> NovoContato(@RequestParam String nome,
                                               @RequestParam Long telefone)
    {return caseContatoPost.NovoContato(nome, telefone);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/EditatContato")
    public ResponseEntity<Contato> EditatContato(@RequestParam Long id,
                                                 @RequestParam String nome,
                                                 @RequestParam Long telefone)
    {return caseContatoPut.EditatContato(id, nome, telefone);}

    @Operation(summary = "Deleta Registro na tabela", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @DeleteMapping("/DeletarContato")
    public void DeletarContato(@RequestParam Long id)
    {caseContatoDelete.DeletarContato(id);}


}
