package App.Service;

import App.CleanArch.Infra.Gateway.PostagemGateway;
import App.Dto.Response.PostagemResponse;
import App.Entity.ComentarioEntity;
import App.Entity.PostagemEntity;
import App.Exception.EntityNotFoundException;
import App.Exception.NullargumentsException;
import App.Mapper.PostagemMapper;
import App.Repository.ComentarioRepositoty;
import App.Repository.PostagemRepositoty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostagemService implements PostagemGateway {


    private final ComentarioRepositoty comentarioRepositoty;
    private final PostagemRepositoty postagemRepositoty;
    @Autowired
    private PostagemMapper postagemMapper;

    public PostagemService(ComentarioRepositoty comentarioRepositoty, PostagemRepositoty postagemRepositoty) {
        this.comentarioRepositoty = comentarioRepositoty;
        this.postagemRepositoty = postagemRepositoty;
    }

    @Override
    public ResponseEntity<List<PostagemResponse>> ListarPostagens()
    {
        try
        {
            List<PostagemEntity> postagems = postagemRepositoty.findAll();
            List<PostagemResponse> responseLista = new ArrayList<>();
            for(PostagemEntity entity : postagems)
            {
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
                responseLista.add(response);
            }
            return new ResponseEntity<>(responseLista, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @Override
    public ResponseEntity<PostagemResponse> BuscarPostagemPorId(Long id)
    {
        try
        {
            if( id != null)
            {
                PostagemEntity entity = postagemRepositoty.findById(id).orElseThrow(
                        ()-> new EntityNotFoundException()
                );
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
                return new ResponseEntity<>(response,HttpStatus.OK);
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
   }

   @Override
    public ResponseEntity<PostagemResponse> NovaPostagem(String titulo, String conteudo)
    {
        try
        {
            if (titulo != null && conteudo != null)
            {
                PostagemEntity entity = new PostagemEntity();
                entity.setTitulo(titulo);
                entity.setConteudo(conteudo);
                postagemRepositoty.save(entity);
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
                return new ResponseEntity<>(response,HttpStatus.CREATED);
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
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<PostagemResponse> EditarPostagem(Long id,
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
                entity.setTitulo(titulo);
                entity.setConteudo(conteudo);
                postagemRepositoty.save(entity);
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
                return new ResponseEntity<>(response,HttpStatus.CREATED);
            }
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<PostagemResponse> AdicionarComentario(Long id, String comentario)
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
                PostagemResponse response = postagemMapper.EntitytoDto(entity);
                return new ResponseEntity<>(response,HttpStatus.CREATED);
            }
            else
            {throw new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
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
