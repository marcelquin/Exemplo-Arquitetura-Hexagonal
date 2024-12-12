package App.Applicatoion.UseCase.Contato;

import App.Infra.Ports.ContatoService;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseUsuarioDelete {

    private final ContatoService contatoService;

    public UseCaseUsuarioDelete(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    public void DeletarContato(@RequestParam Long id)
    {contatoService.DeletarContato(id);}
}
