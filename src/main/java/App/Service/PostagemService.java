package App.Service;

import App.Entity.ComentarioEntity;
import App.Entity.PostagemEntity;
import App.Exception.EntityNotFoundException;
import App.Exception.NullargumentsException;
import App.Repository.ComentarioRepositoty;
import App.Repository.PostagemRepositoty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostagemService {


    private final ComentarioRepositoty comentarioRepositoty;
    private final PostagemRepositoty postagemRepositoty;

    public PostagemService(ComentarioRepositoty comentarioRepositoty, PostagemRepositoty postagemRepositoty) {
        this.comentarioRepositoty = comentarioRepositoty;
        this.postagemRepositoty = postagemRepositoty;
    }

    public void ListarPostagens()
    {
        try
        {
            List<PostagemEntity> postagems = postagemRepositoty.findAll();
            if(postagems != null)
            {
                System.out.println("ok");
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public void BuscarPostagemPorId(Long id)
    {
        try
        {
            if( id != null)
            {
                PostagemEntity entity = postagemRepositoty.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                if(entity != null)
                {
                    System.out.println("ok");
                }
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
   }
    public void NovaPostagem(String titulo, String conteudo)
    {
        try
        {
            if (titulo != null && conteudo != null)
            {
                PostagemEntity entity = new PostagemEntity();
                entity.setTitulo(titulo);
                entity.setConteudo(conteudo);
                postagemRepositoty.save(entity);
            }
            else
            {
                throw new NullargumentsException();
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public void EditarPostagem(Long id,
                               String titulo,
                               String conteudo)
    {
        try
        {
            if(id != null && titulo != null && conteudo != null)
            {
                PostagemEntity entity = postagemRepositoty.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                List<ComentarioEntity> comentarios = new ArrayList<>();
                entity.setTitulo(titulo);
                entity.setConteudo(conteudo);
                entity.setComentarios(comentarios);
                postagemRepositoty.save(entity);
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public void AdicionarComentario(Long id, String comentario)
    {
        try
        {
            if(id != null && comentario != null)
            {
                PostagemEntity entity = postagemRepositoty.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                ComentarioEntity comentarioEntity = new ComentarioEntity();
                comentarioEntity.setTexto(comentario);
                comentarioRepositoty.save(comentarioEntity);
                entity.getComentarios().add(comentarioEntity);
                postagemRepositoty.save(entity);
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }

    public void DeletarPostagem(Long id)
    {
        try
        {
            if( id != null)
            {
                PostagemEntity entity = postagemRepositoty.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                if(entity.getComentarios() != null)
                {
                    for(ComentarioEntity comentario : entity.getComentarios())
                    {
                        comentarioRepositoty.deleteById(comentario.getId());
                    }
                }
                postagemRepositoty.deleteById(entity.getId());
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }



}
