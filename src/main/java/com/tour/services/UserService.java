package com.tour.services;

import com.tour.domain.User;
import com.tour.exception.DaoException;

/**
 * Created by Administrator on 2015/1/20.
 */
public interface UserService {

    public void save(User user) throws DaoException;

    public void update(User user) throws DaoException;

    public User findUserByTel(String tel) throws DaoException;

    public User findUserByTelAndPwd(String tel, String pwd) throws DaoException;

}
