package App.Applicatoion.UseCase.Contato;

import App.Domain.Entity.Contato;
import App.Infra.Ports.ContatoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseUsuarioGet {

    private final ContatoService contatoService;

    public UseCaseUsuarioGet(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    public ResponseEntity<Contato> LocalizarContatoPorId(@RequestParam Long id)
    { return contatoService.LocalizarContatoPorId(id);}
}
