package App.CleanArch.Infra.Gateway;

import App.Dto.Response.PostagemResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PostagemGateway {


    public ResponseEntity<List<PostagemResponse>> ListarPostagens();

    public ResponseEntity<PostagemResponse> BuscarPostagemPorId(@RequestParam Long id);

    public ResponseEntity<PostagemResponse> NovaPostagem(@RequestParam String titulo, @RequestParam String conteudo);

    public ResponseEntity<PostagemResponse> EditarPostagem(@RequestParam Long id,
                               @RequestParam String titulo,
                               @RequestParam String conteudo);

    public ResponseEntity<PostagemResponse> AdicionarComentario(@RequestParam Long id, @RequestParam String comentario);

    public void DeletarPostagem(@RequestParam Long id);
}
