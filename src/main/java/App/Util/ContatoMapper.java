package App.Util;


import App.Domain.Entity.Contato;
import App.Infra.Percistence.Entity.ContatoEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContatoMapper {

    public ContatoEntity DtoToEntity(Contato contato)
    {
        ContatoEntity entity = new ContatoEntity(contato);
        return entity;
    }

    public Contato EntityToDto(ContatoEntity contatoEntity)
    {
        Contato contato = new Contato(contatoEntity);
        return contato;
    }

}
