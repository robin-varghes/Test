package com.rbn.demo.service;

import java.util.List;

import com.rbn.demo.domain.UserRating;

public interface UserRatingService {
	List<UserRating> findAll();

	void saveUserRating(UserRating userRating);

	long totalUserRatingCount();

	double averageUserRatingCount();
}
