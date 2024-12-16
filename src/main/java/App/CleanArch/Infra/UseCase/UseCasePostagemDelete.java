package App.CleanArch.Infra.UseCase;

import App.CleanArch.Infra.Gateway.PostagemGateway;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCasePostagemDelete {

    private final PostagemGateway postagemGateway;

    public UseCasePostagemDelete(PostagemGateway postagemGateway) {
        this.postagemGateway = postagemGateway;
    }

    public void DeletarPostagem(@RequestParam Long id)
    {postagemGateway.DeletarPostagem(id);}
}
