package App.CleanArch.Infra.UseCase;

import App.CleanArch.Infra.Gateway.PostagemGateway;
import App.Dto.Response.PostagemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePostagemPost {

    private final PostagemGateway postagemGateway;

    public UseCasePostagemPost(PostagemGateway postagemGateway) {
        this.postagemGateway = postagemGateway;
    }

    public ResponseEntity<PostagemResponse> NovaPostagem(@RequestParam String titulo, @RequestParam String conteudo)
    {return postagemGateway.NovaPostagem(titulo, conteudo);}

}
