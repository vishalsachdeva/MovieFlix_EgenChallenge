package io.egen.service;

import java.util.List;

import io.egen.entity.Movie;
import io.egen.entity.Rating;
import io.egen.entity.Users;

public interface RatingService {

	Rating addRating(Rating rating);

	List<Rating> findRatingByMovie(Movie movie);

	Rating findRating(Movie movie, Users user);

}
