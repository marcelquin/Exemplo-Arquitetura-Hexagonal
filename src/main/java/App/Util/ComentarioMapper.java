package App.Util;

import App.Domain.Entity.ComentarioResponse;
import App.Infra.Percistence.Entity.ComentarioEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ComentarioMapper {

    ComentarioResponse EntityToDto(ComentarioEntity comentarioEntity);

    ComentarioEntity DtoToEntity(ComentarioResponse comentarioResponse);


}
