package br.com.bieniek.publication.controller;

import br.com.bieniek.publication.controller.request.PublicationRequest;
import br.com.bieniek.publication.controller.response.PublicationResponse;
import br.com.bieniek.publication.domain.Publication;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/v1/publications")
public interface PublicationController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void insert(@RequestBody @Valid final PublicationRequest publicationRequest);

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    List<PublicationResponse> findAll();

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    PublicationResponse findById(@PathVariable final String id);
}
