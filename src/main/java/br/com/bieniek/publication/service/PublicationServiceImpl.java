package br.com.bieniek.publication.service;

import br.com.bieniek.publication.client.CommentClient;
import br.com.bieniek.publication.controller.response.PublicationResponse;
import br.com.bieniek.publication.domain.Publication;
import br.com.bieniek.publication.mapper.PublicationMapper;
import br.com.bieniek.publication.repository.PublicationRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService{

    private final PublicationRepository publicationRepository;
    private final PublicationMapper publicationMapper;
    private final CommentClient commentClient;

    @Override
    public void insert(final Publication publication) {
        var publicationEntity = publicationMapper.toPublicationEntity(publication);
        publicationRepository.save(publicationEntity);
    }

    @Override
    public List<PublicationResponse> findAll() {
        var publications = publicationRepository.findAll();
        return publications.stream()
                .map(publicationMapper::toPublicationResponse)
                .toList();
    }

    @Override
    @CircuitBreaker(name = "comments")
    public PublicationResponse findById(String id) {
        var publication = publicationRepository.findById(id)
                .map(publicationMapper::toPublication)
                .orElseThrow(() -> new RuntimeException("Publication not found"));

        var comments = commentClient.getCommentsByPublicationId(id);
        publication.setComments(comments);

        return publicationMapper.toPublicationResponse(publication);
    }
}
