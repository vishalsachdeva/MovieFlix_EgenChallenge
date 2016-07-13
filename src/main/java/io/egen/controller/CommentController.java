package io.egen.controller;

import java.util.ArrayList;
import java.util.List;

import io.egen.entity.Comment;
import io.egen.entity.Movie;
import io.egen.entity.Users;
import io.egen.exception.MovieNotFoundException;
import io.egen.exception.UserNotFoundException;
import io.egen.service.CommentService;
import io.egen.service.MovieService;
import io.egen.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/comment")
@Api(tags="comment")
public class CommentController {

	@Autowired
	UsersService userService;

	@Autowired
	CommentService commentService;

	@Autowired
	MovieService movieService;

	@RequestMapping(value = "{movieid}/{userid}/{comment}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Add a new comment for a movie", notes = "Returns a comment for a movie")
	public Comment addComment(@PathVariable("movieid") String movieId,
			@PathVariable("userid") String userId,
			@PathVariable("comment") String comment) throws UserNotFoundException, MovieNotFoundException {

		Movie movie = movieService.findById(movieId);
		Users user = userService.findUserById(userId);
		Comment com = commentService.findComment(movie, user);
		if (com == null) {
			com = new Comment();
			com.setMovie(movie);
			com.setUser(user);

		}
		com.setComment(comment);
		return commentService.addComment(com);
	}

	//@SuppressWarnings("null")
	@RequestMapping(value = "{movieid}", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Find comment for a movie", notes = "Find and return the comment for the movie")
	public List<String> findCommentByMovie(@PathVariable("movieid") String movieId) throws MovieNotFoundException {

		Movie movie = movieService.findById(movieId);
		List<Comment> com = commentService.findCommentByMovie(movie);
		List<String> tempcom=new ArrayList<String>();
		for(Comment comment : com){
			tempcom.add(comment.getComment());
		}
		return tempcom;
	}

}
