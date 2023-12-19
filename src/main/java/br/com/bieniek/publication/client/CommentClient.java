package br.com.bieniek.publication.client;

import br.com.bieniek.publication.domain.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "CommentClient", url = "${client.comments.url}")
public interface CommentClient {

    @GetMapping("/comments/publication/{publicationId}")
    List<Comment> getCommentsByPublicationId(@PathVariable("publicationId") final String publicationId);
}
