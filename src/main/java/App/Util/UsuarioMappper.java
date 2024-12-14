package App.Util;

import App.Domain.Entity.Contato;
import App.Domain.Entity.Usuario;
import App.Domain.Exeption.NullargumentsException;
import App.Infra.Percistence.Entity.ContatoEntity;
import App.Infra.Percistence.Entity.UsuarioEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UsuarioMappper {

    private final ContatoMapper contatoMapper;

    public UsuarioMappper(ContatoMapper contatoMapper) {
        this.contatoMapper = contatoMapper;
    }

    public Usuario EntityToDto(UsuarioEntity usuarioEntity)
    {
        if(usuarioEntity != null)
        {
            Usuario usuario = new Usuario(usuarioEntity);
            if(usuarioEntity.getAgenda() != null)
            {
                Usuario response = AdicionarListaDto(usuario,usuarioEntity.getAgenda());
                usuario.setAgenda(response.getAgenda());
            }
            return usuario;
        }
        else
        { throw new NullargumentsException();}
    }

    public Usuario AdicionarListaDto(Usuario usuario,List<ContatoEntity> contatos)
    {
        if(usuario != null)
        {
            for(ContatoEntity con : contatos)
            {
                Contato contato = new Contato(con);
                usuario.getAgenda().add(contato) ;
            }
            return usuario;
        }
        else
        {throw new NullargumentsException();}
    }
    public UsuarioEntity AdicionarListaEntity(UsuarioEntity usuarioEntity,List<Contato> contatos)
    {
        if(usuarioEntity != null)
        {
            for(Contato con : contatos)
            {
                ContatoEntity contato = new ContatoEntity(con);
                usuarioEntity.getAgenda().add(contato) ;
            }
            return usuarioEntity;
        }
        else
        {throw new NullargumentsException();}
    }

    public UsuarioEntity DtoToEntity(Usuario usuario)
    {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
        if(usuarioEntity.getAgenda() != null)
        {
            UsuarioEntity response = AdicionarListaEntity(usuarioEntity,usuario.getAgenda());
            usuarioEntity.getAgenda().addAll(response.getAgenda());
        }
            return usuarioEntity;
    }
}
