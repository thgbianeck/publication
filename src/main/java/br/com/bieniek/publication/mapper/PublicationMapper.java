package br.com.bieniek.publication.mapper;

import br.com.bieniek.publication.domain.Publication;
import br.com.bieniek.publication.repository.entity.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationEntity toPublicationEntity(Publication publication);
    Publication toPublication(PublicationEntity publicationEntity);
}
