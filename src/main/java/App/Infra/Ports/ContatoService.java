package App.Infra.Ports;

import App.Domain.Entity.Contato;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

public interface ContatoService {

    public ResponseEntity<Contato> LocalizarContatoPorId(@RequestParam Long id);

    public ResponseEntity<Contato> NovoContato(@RequestParam String nome,
                                               @RequestParam Long telefone);
    public ResponseEntity<Contato> EditatContato(@RequestParam Long id,
                                                 @RequestParam String nome,
                                                 @RequestParam Long telefone);
    public void DeletarContato(@RequestParam Long id);
}
