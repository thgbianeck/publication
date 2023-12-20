package br.com.bieniek.publication.service;

import br.com.bieniek.publication.client.CommentClient;
import br.com.bieniek.publication.domain.Comment;
import br.com.bieniek.publication.exception.FallBackException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentClient commentClient;

    @Override
    @CircuitBreaker(name = "comments", fallbackMethod = "getCommentsByPublicationIdFallback")
    public List<Comment> getCommentsByPublicationId(String id) {
        return commentClient.getCommentsByPublicationId(id);
    }

    private List<Comment> getCommentsByPublicationIdFallback(String id, Throwable cause) {
        return List.of();
    }
}
