package App.CleanArch.Config;


import App.CleanArch.Infra.Gateway.PostagemGateway;
import App.CleanArch.Infra.UseCase.UseCasePostagemDelete;
import App.CleanArch.Infra.UseCase.UseCasePostagemGet;
import App.CleanArch.Infra.UseCase.UseCasePostagemPost;
import App.CleanArch.Infra.UseCase.UseCasePostagemPut;
import App.Service.PostagemService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostagemConfig {

    @Bean
    UseCasePostagemPost useCasePostagemPost(PostagemGateway postagemGateway)
    {return new UseCasePostagemPost(postagemGateway);}
    @Bean
    UseCasePostagemDelete useCasePostagemDelete(PostagemGateway postagemGateway)
    {return new UseCasePostagemDelete(postagemGateway);}
    @Bean
    UseCasePostagemGet useCasePostagemGet(PostagemGateway postagemGateway)
    {return new UseCasePostagemGet(postagemGateway);}
    @Bean
    UseCasePostagemPut useCasePostagemPut(PostagemGateway postagemGateway)
    {return new UseCasePostagemPut(postagemGateway);}
}
