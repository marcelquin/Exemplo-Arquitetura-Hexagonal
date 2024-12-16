package App.Domain.Repository;

import App.Domain.Entity.PostagemResponse;
import App.Domain.Request.PostagemRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostagemRepository {

    public List<PostagemResponse> ListarPostagens();
    public PostagemResponse BuscarPostagemPorId(Long id);
    public PostagemResponse NovaPostagem(PostagemRequest request);
    public PostagemResponse EditarPostagem(Long id, String titulo, String conteudo);
    public PostagemResponse AdicionarComentario(Long idPost, String comentario);
    public void deletarPostagem(Long id);


}
