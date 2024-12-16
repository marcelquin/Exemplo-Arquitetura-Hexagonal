package App.Controller;

import App.CleanArch.Infra.UseCase.UseCasePostagemDelete;
import App.CleanArch.Infra.UseCase.UseCasePostagemGet;
import App.CleanArch.Infra.UseCase.UseCasePostagemPost;
import App.CleanArch.Infra.UseCase.UseCasePostagemPut;
import App.Dto.Response.PostagemResponse;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("post")
@Tag(name = "post",
        description = "Manipula dados referente a entidade"
)
public class PostagemController {

    private final UseCasePostagemPost casePostagemPost;
    private final UseCasePostagemPut casePostagemPut;
    private final UseCasePostagemGet casePostagemGet;
    private final UseCasePostagemDelete casePostagemDelete;


    public PostagemController(UseCasePostagemPost casePostagemPost, UseCasePostagemPut casePostagemPut, UseCasePostagemGet casePostagemGet, UseCasePostagemDelete casePostagemDelete) {
        this.casePostagemPost = casePostagemPost;
        this.casePostagemPut = casePostagemPut;
        this.casePostagemGet = casePostagemGet;
        this.casePostagemDelete = casePostagemDelete;
    }


    @Operation(summary = "Busca Registros da tabela Por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/ListarPostagens")
    public ResponseEntity<List<PostagemResponse>> ListarPostagens()
    {return casePostagemGet.ListarPostagens();}

    @Operation(summary = "Busca Registros da tabela Por id", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @GetMapping("/BuscarPostagemPorId")
    public ResponseEntity<PostagemResponse> BuscarPostagemPorId(Long id)
    {return casePostagemGet.BuscarPostagemPorId(id);}

    @Operation(summary = "Salva novo Registro na tabela", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PostMapping("/NovaPostagem")
    public ResponseEntity<PostagemResponse> NovaPostagem(String titulo, String conteudo)
    {return casePostagemPost.NovaPostagem(titulo, conteudo);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/EditarPostagem")
    public ResponseEntity<PostagemResponse> EditarPostagem(Long id,
                               String titulo,
                               String conteudo)
    {return casePostagemPut.EditarPostagem(id, titulo, conteudo);}

    @Operation(summary = "Edita Registro na tabela", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @PutMapping("/AdicionarComentario")
    public ResponseEntity<PostagemResponse> AdicionarComentario(Long id, String comentario)
    {return casePostagemPut.AdicionarComentario(id, comentario);}

    @Operation(summary = "Deleta Registro na tabela", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação realizada com sucesso"),
            @ApiResponse(responseCode = "422", description = "Dados de requisição inválida"),
            @ApiResponse(responseCode = "400", description = "Parametros inválidos"),
            @ApiResponse(responseCode = "500", description = "Ops algoo deu errado"),
    })
    @DeleteMapping("/DeletarPostagem")
    public void DeletarPostagem(Long id)
    {casePostagemDelete.DeletarPostagem(id);}
}
