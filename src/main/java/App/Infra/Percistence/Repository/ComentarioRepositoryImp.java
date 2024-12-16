package App.Infra.Percistence.Repository;

import App.Domain.Entity.ComentarioResponse;
import App.Domain.Exeption.EntityNotFoundException;
import App.Domain.Exeption.NullargumentsException;
import App.Infra.Percistence.Entity.ComentarioEntity;
import App.Domain.Repository.ComentarioRepository;
import App.Util.ComentarioMapper;
import org.springframework.stereotype.Component;

@Component
public class ComentarioRepositoryImp implements ComentarioRepository {

    private final JpaComentarioRepository jpaComentarioRepository;
    private final ComentarioMapper comentarioMapper;

    public ComentarioRepositoryImp(JpaComentarioRepository jpaComentarioRepository, ComentarioMapper comentarioMapper) {
        this.jpaComentarioRepository = jpaComentarioRepository;
        this.comentarioMapper = comentarioMapper;
    }

    @Override
    public ComentarioResponse BuscaComentarioPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                ComentarioEntity comentario = jpaComentarioRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException()
                );
                ComentarioResponse response = comentarioMapper.EntityToDto(comentario);
                return response;
            }
            else
            { throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public ComentarioResponse NovoComentario(String comentario)
    {
        try
        {
            if(comentario != null)
            {
                ComentarioEntity entity = new ComentarioEntity();
                entity.setTexto(comentario);
                jpaComentarioRepository.save(entity);
                ComentarioResponse response = comentarioMapper.EntityToDto(entity);
                return response;
            }
            else
            { throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public void DeletarComentarioPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                ComentarioEntity comentario = jpaComentarioRepository.findById(id).orElseThrow(
                        () -> new EntityNotFoundException()
                );
                jpaComentarioRepository.deleteById(id);
            }
            else
            { throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
