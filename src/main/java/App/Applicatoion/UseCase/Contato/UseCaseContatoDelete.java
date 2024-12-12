package App.Applicatoion.UseCase.Contato;

import App.Infra.Ports.ContatoService;
import org.springframework.web.bind.annotation.RequestParam;

public class UseCaseContatoDelete {

    private final ContatoService contatoService;

    public UseCaseContatoDelete(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    public void DeletarContato(@RequestParam Long id)
    {contatoService.DeletarContato(id);}
}
