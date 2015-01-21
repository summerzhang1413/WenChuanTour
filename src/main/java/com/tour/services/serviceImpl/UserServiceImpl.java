package com.tour.services.serviceImpl;

import com.tour.dao.UserDao;
import com.tour.domain.User;
import com.tour.exception.DaoException;
import com.tour.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public void save(User user) throws DaoException {
        userDao.save(user);
    }

    @Override
    public void update(User user) throws DaoException {
        userDao.update(user);
    }

    @Override
    public User findUserByTel(String tel) throws DaoException {
        return userDao.findUserByTel(tel);
    }

    @Override
    public User findUserByTelAndPwd(String tel, String pwd) throws DaoException {
        return userDao.findUserByTelAndPwd(tel, pwd);
    }
}
