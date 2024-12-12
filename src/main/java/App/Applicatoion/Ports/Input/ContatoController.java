package App.Applicatoion.Ports.Input;

import App.Applicatoion.UseCase.Contato.UseCaseContatoDelete;
import App.Applicatoion.UseCase.Contato.UseCaseContatoGet;
import App.Applicatoion.UseCase.Contato.UseCaseContatoPost;
import App.Applicatoion.UseCase.Contato.UseCaseContatoPut;
import App.Domain.Entity.Contato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("Contato")
@RestController
public class ContatoController {

    private final UseCaseContatoDelete caseContatoDelete;
    private final UseCaseContatoPost caseContatoPost;
    private final UseCaseContatoGet caseContatoGet;
    private final UseCaseContatoPut caseContatoPut;

    public ContatoController(UseCaseContatoDelete caseContatoDelete, UseCaseContatoPost caseContatoPost, UseCaseContatoGet caseContatoGet, UseCaseContatoPut caseContatoPut) {
        this.caseContatoDelete = caseContatoDelete;
        this.caseContatoPost = caseContatoPost;
        this.caseContatoGet = caseContatoGet;
        this.caseContatoPut = caseContatoPut;
    }

    @GetMapping("/LocalizarContatoPorId")
    public ResponseEntity<Contato> LocalizarContatoPorId(@RequestParam Long id)
    {return caseContatoGet.LocalizarContatoPorId(id);}

    @PostMapping("/NovoContato")
    public ResponseEntity<Contato> NovoContato(@RequestParam String nome,
                                               @RequestParam Long telefone)
    {return caseContatoPost.NovoContato(nome, telefone);}

    @PutMapping("/EditatContato")
    public ResponseEntity<Contato> EditatContato(@RequestParam Long id,
                                                 @RequestParam String nome,
                                                 @RequestParam Long telefone)
    {return caseContatoPut.EditatContato(id, nome, telefone);}

    @DeleteMapping("/DeletarContato")
    public void DeletarContato(@RequestParam Long id)
    {caseContatoDelete.DeletarContato(id);}


}
