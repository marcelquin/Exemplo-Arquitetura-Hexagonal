package App.CleanArch.Infra.UseCase;

import App.CleanArch.Infra.Gateway.PostagemGateway;
import App.Dto.Response.PostagemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public class UseCasePostagemGet {

    private final PostagemGateway postagemGateway;

    public UseCasePostagemGet(PostagemGateway postagemGateway) {
        this.postagemGateway = postagemGateway;
    }


    public ResponseEntity<List<PostagemResponse>> ListarPostagens()
    {return postagemGateway.ListarPostagens();}

    public ResponseEntity<PostagemResponse> BuscarPostagemPorId(@RequestParam Long id)
    {return postagemGateway.BuscarPostagemPorId(id);}

}
