package br.com.bieniek.publication.service;

import br.com.bieniek.publication.controller.response.PublicationResponse;
import br.com.bieniek.publication.domain.Publication;

import java.util.List;

public interface PublicationService {

    void insert(final Publication publication);
    List<PublicationResponse> findAll();
    PublicationResponse findById(final String id);

}
