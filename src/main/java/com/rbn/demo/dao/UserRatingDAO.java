package com.rbn.demo.dao;

import java.util.List;

import com.rbn.demo.domain.UserRating;

public interface UserRatingDAO {
    List<UserRating>findAll();
    void saveUserRating(UserRating userRating);
    long totalUserRatingCount();
    double averageUserRatingCount();
}
