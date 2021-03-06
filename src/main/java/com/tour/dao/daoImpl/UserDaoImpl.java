package com.tour.dao.daoImpl;

import com.tour.dao.BaseDao;
import com.tour.dao.UserDao;
import com.tour.domain.User;
import com.tour.exception.DaoException;
import com.tour.util.DaoUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Repository("userDaoImpl")
public class UserDaoImpl implements UserDao {
    @Autowired
    private BaseDao baseDao;

    private SessionFactory sessionFactory;

    @Resource(name = "sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    public SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }

    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(User user) throws DaoException {
        baseDao.save(user);
    }

    @Override
    public void update(User user) throws DaoException {
        baseDao.update(user);
    }

    @Override
    public User findUserByTel(String tel) throws DaoException {
        String hql = "from User u where u.userTel = ?";
        String[] params = {tel};
        List<User> list = DaoUtil.getListResultByHql(getSession(), hql, params);
        if (DaoUtil.isNullForList(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public User findUserByTelAndPwd(String tel, String pwd) throws DaoException {
        String hql = "from User u where u.userTel = ? and u.userPwd = ?";
        String[] params = {tel, pwd};
        List<User> list = DaoUtil.getListResultByHql(getSession(), hql, params);
        if (DaoUtil.isNullForList(list)){
            return null;
        }
        return list.get(0);
    }

    @Override
    public String findAllFriends(String userTel) throws DaoException {
        User user = findUserByTel(userTel);
        String friends = user.getFriend();
        return friends;
    }

}
