package App.Infra.Config;

import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioDelete;
import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioGet;
import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioPost;
import App.Applicatoion.UseCase.Usuario.UseCaseUsuarioPut;
import App.Infra.Ports.UsuarioService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    UseCaseUsuarioGet useCaseUsuarioGet(UsuarioService usuarioService)
    {return  new UseCaseUsuarioGet(usuarioService);}
    @Bean
    UseCaseUsuarioPost useCaseUsuarioPost(UsuarioService usuarioService)
    {return new UseCaseUsuarioPost(usuarioService);}
    @Bean
    UseCaseUsuarioPut useCaseUsuarioPut(UsuarioService usuarioService)
    {return  new UseCaseUsuarioPut(usuarioService);}
    @Bean
    UseCaseUsuarioDelete useCaseUsuarioDelete(UsuarioService usuarioService)
    {return new UseCaseUsuarioDelete(usuarioService);}
}
