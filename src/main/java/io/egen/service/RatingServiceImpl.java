package io.egen.service;

import io.egen.dao.RatingDao;
import io.egen.entity.Movie;
import io.egen.entity.Rating;
import io.egen.entity.Users;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;

	@Override
	public Rating addRating(Rating rating) {
		Rating rate = ratingDao.addRating(rating);
		return rate;
	}

	@Override
	public List<Rating> findRatingByMovie(Movie movie) {

		return ratingDao.findRatingByMovie(movie);
	}

	@Override
	public Rating findRating(Movie movie, Users user) {
		
		return ratingDao.findRating(movie,user);
	}

}
