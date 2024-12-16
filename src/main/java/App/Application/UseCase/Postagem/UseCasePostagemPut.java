package App.Application.UseCase.Postagem;

import App.Domain.Entity.PostagemResponse;
import App.Infra.Ports.PostagemService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePostagemPut {

    private final PostagemService postagemService;

    public UseCasePostagemPut(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    public ResponseEntity<PostagemResponse> EditarPostagem(@RequestParam Long id,
                                                           @RequestParam String titulo,
                                                           @RequestParam String conteudo)
    {return postagemService.EditarPostagem(id, titulo, conteudo);}

    public ResponseEntity<PostagemResponse> AdicionarComentario(@RequestParam Long id, @RequestParam String comentario)
    {return postagemService.AdicionarComentario(id, comentario);}
}
