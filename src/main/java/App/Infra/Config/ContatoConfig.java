package App.Infra.Config;

import App.Applicatoion.UseCase.Contato.UseCaseContatoDelete;
import App.Applicatoion.UseCase.Contato.UseCaseContatoGet;
import App.Applicatoion.UseCase.Contato.UseCaseContatoPost;
import App.Applicatoion.UseCase.Contato.UseCaseContatoPut;
import App.Infra.Ports.ContatoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContatoConfig {

    @Bean
    UseCaseContatoGet useCaseContatoGet(ContatoService contatoService)
    {return new UseCaseContatoGet(contatoService);}
    @Bean
    UseCaseContatoPost useCaseContatoPost(ContatoService contatoService)
    {return new UseCaseContatoPost(contatoService);}
    @Bean
    UseCaseContatoPut useCaseContatoPut(ContatoService contatoService)
    {return new UseCaseContatoPut(contatoService);}
    @Bean
    UseCaseContatoDelete useCaseContatoDelete(ContatoService contatoService)
    { return new UseCaseContatoDelete(contatoService);}
}
