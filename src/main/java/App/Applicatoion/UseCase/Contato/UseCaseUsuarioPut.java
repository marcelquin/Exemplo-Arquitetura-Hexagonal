package App.Applicatoion.UseCase.Contato;

import App.Domain.Entity.Contato;
import App.Infra.Ports.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseUsuarioPut {

    private final ContatoService contatoService;

    public UseCaseUsuarioPut(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    public ResponseEntity<Contato> EditatContato(@RequestParam Long id,
                                                 @RequestParam String nome,
                                                 @RequestParam Long telefone)
    {return contatoService.EditatContato(id, nome, telefone);}


}
