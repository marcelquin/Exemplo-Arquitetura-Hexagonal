package App.Applicatoion.UseCase.Contato;

import App.Domain.Entity.Contato;
import App.Infra.Ports.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseContatoPost {

    private final ContatoService contatoService;

    public UseCaseContatoPost(ContatoService contatoService) {
        this.contatoService = contatoService;
    }


    public ResponseEntity<Contato> NovoContato(@RequestParam String nome,
                                               @RequestParam Long telefone)
    { return contatoService.NovoContato(nome, telefone);}
}
