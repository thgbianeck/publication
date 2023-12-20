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
    private final RedisService redisService;

    @Override
    @CircuitBreaker(name = "comments", fallbackMethod = "getCommentsByPublicationIdFallback")
    public List<Comment> getCommentsByPublicationId(String id) {
        var comments = commentClient.getCommentsByPublicationId(id);
        redisService.save(comments, id);
        return comments;
    }

    private List<Comment> getCommentsByPublicationIdFallback(String id, Throwable cause) {
        log.warn("[WARN] fallback with id {}", id);
        return redisService.findById(id);
    }
}
