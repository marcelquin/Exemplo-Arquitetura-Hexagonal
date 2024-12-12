package App.Infra.Percistence.Repository;

import App.Domain.Entity.Contato;
import App.Domain.Exeption.EntityNotFoundException;
import App.Domain.Exeption.NullargumentsException;
import App.Infra.Percistence.Entity.ContatoEntity;
import App.Domain.Repository.ContatoRepository;
import App.Util.ContatoMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ContatoRepositoryImp implements ContatoRepository {

    private final ContatoEntityRepository repository;
    private final ContatoMapper contatoMapper;

    public ContatoRepositoryImp(ContatoEntityRepository repository, ContatoMapper contatoMapper) {
        this.repository = repository;
        this.contatoMapper = contatoMapper;
    }


    @Override
    public Contato Salvar(Contato contato)
    {
        try
        {
           if(contato != null)
           {
               ContatoEntity entity = contatoMapper.DtoToEntity(contato);
               repository.save(entity);
               return contato;
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
    public Contato Editar(Contato contato)
    {
        try
        {
            if(contato != null)
            {

                ContatoEntity entity = repository.findById(contato.getId()).orElseThrow(()-> new EntityNotFoundException());
                entity.setNome(contato.getNome());
                entity.setNumero(contato.getNumero());
                repository.save(entity);
                Contato response = contatoMapper.EntityToDto(entity);
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
    public Optional<Contato> BuscarPorId(Long id)
    {
        try
        {
            if( id != null)
            {
                ContatoEntity entity = repository.findById(id).orElseThrow(()-> new EntityNotFoundException());
                Contato response = contatoMapper.EntityToDto(entity);
                return Optional.ofNullable(response);
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
}
