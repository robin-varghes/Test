package com.rbn.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rbn.demo.dao.UserRatingDAO;
import com.rbn.demo.domain.UserRating;

@Service("UserRatingService")
@Transactional
public class UserRatingServiceImpl implements UserRatingService{
	
    @Autowired
	private UserRatingDAO userRatingDAO;
	
	@Override
	public List<UserRating> findAll() {
		return userRatingDAO.findAll();
	}

	@Override
	public void saveUserRating(UserRating userRating) {
		userRatingDAO.saveUserRating(userRating);		
	}

	@Override
	public long totalUserRatingCount() {
		return userRatingDAO.totalUserRatingCount();
	}

	@Override
	public double averageUserRatingCount() {
		return userRatingDAO.averageUserRatingCount();
	}

}
