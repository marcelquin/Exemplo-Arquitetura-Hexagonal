package App.Util;

import App.Domain.Entity.Contato;
import App.Domain.Entity.Usuario;
import App.Domain.Exeption.NullargumentsException;
import App.Infra.Percistence.Entity.ContatoEntity;
import App.Infra.Percistence.Entity.UsuarioEntity;
import org.springframework.stereotype.Component;

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
            List<Contato> contatoes = (List<Contato>) contatoMapper.EntityToDto((ContatoEntity) usuarioEntity.getAgenda());
            usuario.setAgenda(contatoes);
            return usuario;
        }
        else
        { throw new NullargumentsException();}
    }

    public UsuarioEntity DtoToEntity(Usuario usuario)
    {
        if(usuario != null)
        {
            UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
            return usuarioEntity;
        }
        else
        { throw new NullargumentsException();}
    }
}
