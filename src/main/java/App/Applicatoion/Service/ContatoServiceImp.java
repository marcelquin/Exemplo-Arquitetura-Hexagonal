package App.Applicatoion.Service;

import App.Domain.Entity.Contato;
import App.Domain.Exeption.NullargumentsException;
import App.Domain.Repository.ContatoRepository;
import App.Infra.Percistence.Entity.ContatoEntity;
import App.Infra.Ports.ContatoService;
import App.Util.ContatoMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ContatoServiceImp implements ContatoService {

    private final ContatoRepository contatoRepository;
    private final ContatoMapper contatoMapper;

    public ContatoServiceImp(ContatoRepository contatoRepository, ContatoMapper contatoMapper) {
        this.contatoRepository = contatoRepository;
        this.contatoMapper = contatoMapper;
    }


    @Override
    public ResponseEntity<Contato> LocalizarContatoPorId(Long id)
    {
        try
        {
            if(id != null)
            {
                Contato response = contatoRepository.BuscarPorId(id).get();
                return new ResponseEntity<>(response, HttpStatus.OK);
            }
            else
            {throw  new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Contato> NovoContato(String nome, Long telefone)
    {
        try
        {
            if(nome != null && telefone != null)
            {
               Contato contato = new Contato();
               contato.setNome(nome);
               contato.setNumero(telefone);
               Contato response = contatoRepository.Salvar(contato);
               return new ResponseEntity<>(response, HttpStatus.CREATED);
            }
            else
            {throw  new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Contato> EditatContato(Long id, String nome, Long telefone)
    {
        try
        {
            if(id != null && nome != null && telefone != null)
            {
                Contato contato = contatoRepository.BuscarPorId(id).get();
                ContatoEntity entity = contatoMapper.DtoToEntity(contato);
                entity.setNome(nome);
                entity.setNumero(telefone);
                Contato contatoNovo = contatoMapper.EntityToDto(entity);
                contatoRepository.Salvar(contatoNovo);
                return  new ResponseEntity<>(contatoNovo, HttpStatus.OK);
            }
            else
            {throw  new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public void DeletarContato(Long id)
    {
        try
        {
            if(id != null)
            {
                contatoRepository.DeletarContato(id);
            }
            else
            {throw  new NullargumentsException();}
        }
        catch (Exception e)
        {
            e.getMessage();
        }
    }
}
