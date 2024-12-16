package App.Util;


import App.Domain.Entity.PostagemResponse;
import App.Infra.Percistence.Entity.PostagemEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface PostagemMapper {

    /*@Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "titulo", target = "titulo"),
            @Mapping(source = "conteudo", target = "conteudo"),
            @Mapping(source = "comentarios", target = "comentarios")
    })*/
    PostagemResponse EntitytoDto(PostagemEntity postagemEntity);

    PostagemEntity DtoToEntity(PostagemResponse postagemResponse);
}
