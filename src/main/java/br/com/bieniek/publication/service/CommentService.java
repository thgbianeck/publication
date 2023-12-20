package br.com.bieniek.publication.service;

import br.com.bieniek.publication.domain.Comment;

import java.util.List;

public interface CommentService {


    List<Comment> getCommentsByPublicationId(final String id);

}
