package io.egen.service;

import java.util.List;

import io.egen.entity.Comment;
import io.egen.entity.Movie;
import io.egen.entity.Users;

public interface CommentService {

	Comment findComment(Movie movie, Users user);

	Comment addComment(Comment com);

	List<Comment> findCommentByMovie(Movie movie);

}
