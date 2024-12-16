package App.Application.UseCase.Postagem;

import App.Domain.Entity.PostagemResponse;
import App.Infra.Ports.PostagemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePostagemPost {

    private final PostagemService postagemService;

    public UseCasePostagemPost(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    public ResponseEntity<PostagemResponse> NovaPostagem(@RequestParam String titulo, @RequestParam String conteudo)
    {return postagemService.NovaPostagem(titulo, conteudo);}

}
