package App.Application.Service;

import App.Domain.Entity.PostagemResponse;
import App.Domain.Repository.PostagemRepository;
import App.Domain.Request.PostagemRequest;

import App.Domain.Exeption.NullargumentsException;
import App.Infra.Ports.PostagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostagemServiceImp implements PostagemService {


    private final PostagemRepository  postagemRepository;

    public PostagemServiceImp(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }


    @Override
    public ResponseEntity<List<PostagemResponse>> ListarPostagens()
    {
        try
        {
            List<PostagemResponse> postagems = postagemRepository.ListarPostagens();
            return new ResponseEntity<>(postagems, HttpStatus.OK);
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
                PostagemResponse response = postagemRepository.BuscarPostagemPorId(id);
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
                PostagemRequest request = new PostagemRequest(titulo,conteudo);
                PostagemResponse response = postagemRepository.NovaPostagem(request);
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
                PostagemResponse response = postagemRepository.EditarPostagem(id,titulo,conteudo);
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
                PostagemResponse response = postagemRepository.AdicionarComentario(id,comentario);
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
               postagemRepository.deletarPostagem(id);
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
