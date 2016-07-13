package io.egen.dao;

import java.util.List;

import io.egen.entity.Comment;
import io.egen.entity.Movie;
import io.egen.entity.Users;

public interface CommentDao {

	public Comment findComment(Movie movie, Users user);

	public Comment addComment(Comment com);

	public List<Comment> findCommentByMovie(Movie movie);

}
