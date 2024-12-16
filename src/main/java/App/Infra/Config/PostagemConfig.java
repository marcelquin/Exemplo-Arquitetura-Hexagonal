package App.Infra.Config;


import App.Infra.Ports.PostagemService;
import App.Application.UseCase.Postagem.UseCasePostagemDelete;
import App.Application.UseCase.Postagem.UseCasePostagemGet;
import App.Application.UseCase.Postagem.UseCasePostagemPost;
import App.Application.UseCase.Postagem.UseCasePostagemPut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostagemConfig {

    @Bean
    UseCasePostagemPost useCasePostagemPost(PostagemService postagemService)
    {return new UseCasePostagemPost(postagemService);}
    @Bean
    UseCasePostagemDelete useCasePostagemDelete(PostagemService postagemService)
    {return new UseCasePostagemDelete(postagemService);}
    @Bean
    UseCasePostagemGet useCasePostagemGet(PostagemService postagemService)
    {return new UseCasePostagemGet(postagemService);}
    @Bean
    UseCasePostagemPut useCasePostagemPut(PostagemService postagemService)
    {return new UseCasePostagemPut(postagemService);}
}
