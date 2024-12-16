package App.Application.UseCase.Postagem;

import App.Infra.Ports.PostagemService;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePostagemDelete {

    private final PostagemService postagemService;

    public UseCasePostagemDelete(PostagemService postagemService) {
        this.postagemService = postagemService;
    }

    public void DeletarPostagem(@RequestParam Long id)
    {
        postagemService.DeletarPostagem(id);}
}
