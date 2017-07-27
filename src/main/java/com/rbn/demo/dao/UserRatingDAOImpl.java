package com.rbn.demo.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rbn.demo.domain.UserRating;

@Repository("UserRatingDAO")
public class UserRatingDAOImpl implements UserRatingDAO {
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	@Override
	public List<UserRating> findAll() {
		return sessionFactory.getCurrentSession().createQuery("from UserRating").list();
	}

	@Override
	public void saveUserRating(UserRating userRating) {
		sessionFactory.getCurrentSession().save(userRating);
	}

	@Override
	public long totalUserRatingCount() {
		return  (long) sessionFactory.getCurrentSession().createQuery("select count(*) from UserRating").uniqueResult();
	}

	@Override
	public double averageUserRatingCount() {
		Double avg = (Double) sessionFactory.getCurrentSession().createQuery("select avg(ur.rating) from UserRating ur").uniqueResult();
		return  avg.doubleValue();
	}

}
