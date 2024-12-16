package App.CleanArch.Infra.UseCase;

import App.CleanArch.Infra.Gateway.PostagemGateway;
import App.Dto.Response.PostagemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePostagemPut {

    private final PostagemGateway postagemGateway;

    public UseCasePostagemPut(PostagemGateway postagemGateway) {
        this.postagemGateway = postagemGateway;
    }

    public ResponseEntity<PostagemResponse> EditarPostagem(@RequestParam Long id,
                                                           @RequestParam String titulo,
                                                           @RequestParam String conteudo)
    {return postagemGateway.EditarPostagem(id, titulo, conteudo);}

    public ResponseEntity<PostagemResponse> AdicionarComentario(@RequestParam Long id, @RequestParam String comentario)
    {return postagemGateway.AdicionarComentario(id, comentario);}
}
