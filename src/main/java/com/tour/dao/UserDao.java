package com.tour.dao;

import com.tour.domain.User;
import com.tour.exception.DaoException;

public interface UserDao {

    public void save(User user) throws DaoException;

    public void update(User user) throws DaoException;

    public User findUserByTel(String tel) throws DaoException;

    public User findUserByTelAndPwd(String tel, String pwd) throws DaoException;


}
