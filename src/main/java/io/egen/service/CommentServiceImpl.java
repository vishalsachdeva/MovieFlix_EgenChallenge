package io.egen.service;

import io.egen.dao.CommentDao;
import io.egen.entity.Comment;
import io.egen.entity.Movie;
import io.egen.entity.Users;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDao commentDao;
	
	
	
	@Override
	public Comment findComment(Movie movie, Users user) {
	
		return commentDao.findComment(movie,user);
	}

	@Override
	public Comment addComment(Comment com) {
		Comment comment= commentDao.addComment(com);
		return comment;
	}

	@Override
	public List<Comment> findCommentByMovie(Movie movie) {
		
		return commentDao.findCommentByMovie(movie);
	}

}
