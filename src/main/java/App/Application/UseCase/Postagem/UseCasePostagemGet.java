package App.Application.UseCase.Postagem;

import App.Domain.Entity.PostagemResponse;
import App.Infra.Ports.PostagemService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCasePostagemGet {

    private final PostagemService postagemService;

    public UseCasePostagemGet(PostagemService postagemService) {
        this.postagemService = postagemService;
    }


    public ResponseEntity<List<PostagemResponse>> ListarPostagens()
    {return postagemService.ListarPostagens();}

    public ResponseEntity<PostagemResponse> BuscarPostagemPorId(@RequestParam Long id)
    {return postagemService.BuscarPostagemPorId(id);}

}
