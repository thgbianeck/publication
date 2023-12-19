package br.com.bieniek.publication.controller;

import br.com.bieniek.publication.controller.request.PublicationRequest;
import br.com.bieniek.publication.controller.response.PublicationResponse;
import br.com.bieniek.publication.domain.Publication;
import br.com.bieniek.publication.mapper.PublicationMapper;
import br.com.bieniek.publication.service.PublicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PublicationControllerImpl implements PublicationController {

    private final PublicationService publicationService;
    private final PublicationMapper publicationMapper;

    @Override
    public void insert(final PublicationRequest publicationRequest) {
        var publication = publicationMapper.toPublication(publicationRequest);
        publicationService.insert(publication);
    }

    @Override
    public List<PublicationResponse> findAll() {
        return publicationService.findAll();
    }

    @Override
    public PublicationResponse findById(String id) {
        return publicationService.findById(id);
    }
}
