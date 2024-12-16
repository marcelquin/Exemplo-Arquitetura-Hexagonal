package App.Infra.Percistence.Repository;

import App.Domain.Entity.ComentarioResponse;
import App.Domain.Entity.PostagemResponse;
import App.Domain.Exeption.EntityNotFoundException;
import App.Domain.Exeption.NullargumentsException;
import App.Domain.Request.PostagemRequest;
import App.Infra.Percistence.Entity.ComentarioEntity;
import App.Infra.Percistence.Entity.PostagemEntity;
import App.Domain.Repository.ComentarioRepository;
import App.Domain.Repository.PostagemRepository;
import App.Util.ComentarioMapper;
import App.Util.PostagemMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PostagemRepositoryImp implements PostagemRepository {

    private final JpaPostagemRepositoty jpaPostagemRepositoty;
    private final ComentarioRepository comentarioRepository;
    private final PostagemMapper postagemMapper;
    private final ComentarioMapper comentarioMapper;

    public PostagemRepositoryImp(JpaPostagemRepositoty jpaPostagemRepositoty, ComentarioRepository comentarioRepository, PostagemMapper postagemMapper, ComentarioMapper comentarioMapper) {
        this.jpaPostagemRepositoty = jpaPostagemRepositoty;
        this.comentarioRepository = comentarioRepository;
        this.postagemMapper = postagemMapper;
        this.comentarioMapper = comentarioMapper;
    }


    @Override
    public List<PostagemResponse> ListarPostagens()
    {
        try
        {
            List<PostagemEntity> postagemEntities = jpaPostagemRepositoty.findAll();
            List<PostagemResponse> responses = new ArrayList<>();
            for(PostagemEntity entity : postagemEntities)
            {
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
                responses.add(response);
            }
            return responses;
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public PostagemResponse BuscarPostagemPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                PostagemEntity entity = jpaPostagemRepositoty.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
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
    public PostagemResponse NovaPostagem(PostagemRequest request)
    {
        try
        {
            if(request != null)
            {
                PostagemEntity entity = new PostagemEntity();
                entity.setTitulo(request.titulo());
                entity.setConteudo(request.conteudo());
                List<ComentarioEntity> comentarios = new ArrayList<>();
                entity.setComentarios(comentarios);
                jpaPostagemRepositoty.save(entity);
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
                return response;
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return null;
    }

    @Override
    public PostagemResponse EditarPostagem(Long id, String titulo, String conteudo)
    {
        try
        {
            if(id != null)
            {
                PostagemEntity entity = jpaPostagemRepositoty.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                entity.setTitulo(titulo);
                entity.setConteudo(conteudo);
                jpaPostagemRepositoty.save(entity);
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
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
    public PostagemResponse AdicionarComentario(Long idPost, String comentario)
    {
        try
        {
            if(idPost != null && comentario != null)
            {
                PostagemEntity entity = jpaPostagemRepositoty.findById(idPost).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                ComentarioResponse comentarioResponse = comentarioRepository.NovoComentario(comentario);
                ComentarioEntity comentarioEntity = comentarioMapper.DtoToEntity(comentarioResponse);
                entity.getComentarios().add(comentarioEntity);
                jpaPostagemRepositoty.save(entity);
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
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
    public void deletarPostagem(Long id)
    {
        try
        {
            if(id != null)
            {
                PostagemEntity postagem = jpaPostagemRepositoty.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                if(postagem.getComentarios() != null)
                {
                    for(ComentarioEntity comentario : postagem.getComentarios())
                    {
                        comentarioRepository.DeletarComentarioPorId(id);
                    }
                }
                jpaPostagemRepositoty.deleteById(id);
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
