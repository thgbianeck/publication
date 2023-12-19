package br.com.bieniek.publication.mapper;

import br.com.bieniek.publication.controller.request.PublicationRequest;
import br.com.bieniek.publication.controller.response.PublicationResponse;
import br.com.bieniek.publication.domain.Publication;
import br.com.bieniek.publication.repository.entity.PublicationEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublicationMapper {

    PublicationEntity toPublicationEntity(Publication publication);
    Publication toPublication(PublicationEntity publicationEntity);
    Publication toPublication(PublicationRequest publicationRequest);
    PublicationResponse toPublicationResponse(PublicationEntity publicationEntity);
    PublicationResponse toPublicationResponse(Publication publication);
}
