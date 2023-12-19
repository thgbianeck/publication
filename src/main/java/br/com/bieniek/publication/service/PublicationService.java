package br.com.bieniek.publication.service;

import br.com.bieniek.publication.domain.Publication;

import java.util.List;

public interface PublicationService {

    void insert(final Publication publication);
    List<Publication> findAll();
    Publication findById(final String id);

}
