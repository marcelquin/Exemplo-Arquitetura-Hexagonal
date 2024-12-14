package App.Applicatoion.Service;

import App.Applicatoion.UseCase.Contato.UseCaseContatoDelete;
import App.Applicatoion.UseCase.Contato.UseCaseContatoPost;
import App.Domain.Entity.Contato;
import App.Domain.Entity.Usuario;
import App.Domain.Exeption.NullargumentsException;
import App.Domain.Repository.UsuarioRepository;
import App.Infra.Percistence.Entity.ContatoEntity;
import App.Infra.Percistence.Entity.UsuarioEntity;
import App.Infra.Ports.UsuarioService;
import App.Util.ContatoMapper;
import App.Util.UsuarioMappper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class UsuarioServiceImp implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UseCaseContatoPost caseContatoPost;
    private final UseCaseContatoDelete caseContatoDelete;
    private final UsuarioMappper usuarioMappper;
    private final ContatoMapper contatoMapper;

    public UsuarioServiceImp(UsuarioRepository usuarioRepository, UseCaseContatoPost caseContatoPost, UseCaseContatoDelete caseContatoDelete, UsuarioMappper usuarioMappper, ContatoMapper contatoMapper) {
        this.usuarioRepository = usuarioRepository;
        this.caseContatoPost = caseContatoPost;
        this.caseContatoDelete = caseContatoDelete;
        this.usuarioMappper = usuarioMappper;
        this.contatoMapper = contatoMapper;
    }


    @Override
    public ResponseEntity<List<Usuario>> ListarUsuarios()
    {
        try
        {
            List<Usuario> usuarioEntities = usuarioRepository.ListarUsuarios();
            return new ResponseEntity<>(usuarioEntities, HttpStatus.OK);
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Usuario> BuscarUsuarioPorId(Long id)
    {
        try
        {
            if( id != null)
            {
                Usuario response = usuarioRepository.BuscarPorId(id).get();
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
    public ResponseEntity<Usuario> NovoUsuario(String nome)
    {
        try
        {
            if( nome != null)
            {
                Usuario usuario = new Usuario();
                usuario.setNome(nome);
                System.out.println(usuario.getNome());
                usuarioRepository.Salvar(usuario);

                return new ResponseEntity<>(HttpStatus.CREATED);
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
    public ResponseEntity<Usuario> AdicionarContato(Long id, String nome, Long telefone)
    {
        try
        {
            if( id != null && nome != null && telefone != null)
            {
                Contato contato = caseContatoPost.NovoContato(nome,telefone).getBody();
                Usuario usuario = usuarioRepository.BuscarPorId(id).get();
                usuarioRepository.Adicionar(id,contato.getId());
                return new ResponseEntity<>(HttpStatus.OK);
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
    public ResponseEntity<Usuario> EditarUsuario(Long idUsuario, String nome)
    {
        try
        {
            if( idUsuario != null && nome != null)
            {
                Usuario usuario = usuarioRepository.BuscarPorId(idUsuario).get();
                UsuarioEntity entity = usuarioMappper.DtoToEntity(usuario);
                entity.setNome(nome);
                Usuario novoUsuario = usuarioMappper.EntityToDto(entity);
                usuarioRepository.Salvar(novoUsuario);
                return new ResponseEntity<>(novoUsuario, HttpStatus.OK);
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
    public void DeletarUsuarioPorId(Long id)
    {
        try
        {
            if( id != null)
            {
                Usuario entity = usuarioRepository.BuscarPorId(id).get();
                UsuarioEntity usuario = usuarioMappper.DtoToEntity(entity);
                for(ContatoEntity contato : usuario.getAgenda())
                {
                    caseContatoDelete.DeletarContato(contato.getId());
                }
                usuarioRepository.DeletarUsuario(usuario.getId());
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
