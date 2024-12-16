package App.Domain.Repository;

import App.Domain.Entity.ComentarioResponse;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository {

    public ComentarioResponse BuscaComentarioPorId(Long id);
    public ComentarioResponse NovoComentario(String comentario);
    public void DeletarComentarioPorId(Long id);

}
