package io.egen.dao;

import java.util.List;

import io.egen.entity.Movie;
import io.egen.entity.Rating;
import io.egen.entity.Users;

public interface RatingDao {

	public Rating addRating(Rating rating);

	public List<Rating> findRatingByMovie(Movie movie);

	public Rating findRating(Movie movie, Users user);

}
