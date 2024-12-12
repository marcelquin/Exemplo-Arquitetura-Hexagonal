package App.Infra.Config;

import App.Applicatoion.UseCase.Contato.UseCaseUsuarioDelete;
import App.Applicatoion.UseCase.Contato.UseCaseUsuarioGet;
import App.Applicatoion.UseCase.Contato.UseCaseUsuarioPost;
import App.Applicatoion.UseCase.Contato.UseCaseUsuarioPut;
import App.Infra.Ports.ContatoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContatoConfig {

    @Bean
    UseCaseUsuarioGet useCaseUsuarioGet(ContatoService contatoService)
    {return new UseCaseUsuarioGet(contatoService);}
    @Bean
    UseCaseUsuarioPost useCaseUsuarioPost(ContatoService contatoService)
    {return new UseCaseUsuarioPost(contatoService);}
    @Bean
    UseCaseUsuarioPut useCaseUsuarioPut(ContatoService contatoService)
    {return new UseCaseUsuarioPut(contatoService);}
    @Bean
    UseCaseUsuarioDelete useCaseUsuarioDelete(ContatoService contatoService)
    { return new UseCaseUsuarioDelete(contatoService);}
}
