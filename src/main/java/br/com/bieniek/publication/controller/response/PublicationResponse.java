package br.com.bieniek.publication.controller.response;

import br.com.bieniek.publication.domain.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicationResponse {

    private String id;
    private String title;
    private String imageUrl;
    private String text;
    private List<Comment> comments;
}
