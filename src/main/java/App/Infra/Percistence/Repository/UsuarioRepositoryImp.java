package App.Infra.Percistence.Repository;

import App.Domain.Entity.Contato;
import App.Domain.Entity.Usuario;
import App.Domain.Exeption.EntityNotFoundException;
import App.Domain.Exeption.NullargumentsException;
import App.Domain.Repository.ContatoRepository;
import App.Domain.Repository.UsuarioRepository;
import App.Infra.Percistence.Entity.ContatoEntity;
import App.Infra.Percistence.Entity.UsuarioEntity;
import App.Util.ContatoMapper;
import App.Util.UsuarioMappper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class UsuarioRepositoryImp implements UsuarioRepository {

    private final UsuarioEntityRepository usuarioEntityRepository;
    private final ContatoRepository contatoRepository;
    private final UsuarioMappper usuarioMappper;
    private final ContatoMapper contatoMapper;

    public UsuarioRepositoryImp(UsuarioEntityRepository usuarioEntityRepository, ContatoRepository contatoRepository, UsuarioMappper usuarioMappper, ContatoMapper contatoMapper) {
        this.usuarioEntityRepository = usuarioEntityRepository;
        this.contatoRepository = contatoRepository;
        this.usuarioMappper = usuarioMappper;
        this.contatoMapper = contatoMapper;
    }


    @Override
    public Usuario Salvar(Usuario usuario)
    {
        if(usuario.getId() == null)
        {
            UsuarioEntity entity = usuarioMappper.DtoToEntity(usuario);
            List<ContatoEntity> contatos = new ArrayList<>();
            entity.setAgenda(contatos);
            usuarioEntityRepository.save(entity);
            return usuario;
        }
        return null;
    }


    @Override
    public Usuario Editar(Usuario usuario)
    {
        UsuarioEntity entity = usuarioEntityRepository.findById(usuario.getId()).orElseThrow(()-> new EntityNotFoundException());
        entity.setNome(usuario.getNome());
        usuarioEntityRepository.save(entity);
        Usuario response = usuarioMappper.EntityToDto(entity);
        return response;
    }

    @Override
    public Usuario Adicionar(Long idUsuario, Long idContato)
    {
        try
        {
            if(idUsuario != null && idContato != null)
            {
                UsuarioEntity entity = usuarioEntityRepository.findById(idUsuario).orElseThrow(()-> new EntityNotFoundException());
                Contato contato = contatoRepository.BuscarPorId(idContato).orElseThrow(()-> new EntityNotFoundException());
                ContatoEntity contatoEntity = new ContatoEntity(contato);
                entity.getAgenda().add(contatoEntity);
                usuarioEntityRepository.save(entity);
                Usuario response = new Usuario(entity);
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
    public Optional<Usuario> BuscarPorId(Long id)
    {
        if(id != null)
        {
            UsuarioEntity entity = usuarioEntityRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
            Usuario response = usuarioMappper.EntityToDto(entity);
            return Optional.ofNullable(response);
        }
        else
        { throw new NullargumentsException();}
    }

    @Override
    public List<Usuario> ListarUsuarios()
    {
        List<UsuarioEntity> usuarioEntities = usuarioEntityRepository.findAll();
        List<Usuario> response = new ArrayList<>();
        for(UsuarioEntity entity : usuarioEntities)
        {
            Usuario usuario = usuarioMappper.EntityToDto(entity);
            response.add(usuario);
        }
        return response;
    }

    @Override
    public void DeletarUsuario(Long id)
    {

    }
}
