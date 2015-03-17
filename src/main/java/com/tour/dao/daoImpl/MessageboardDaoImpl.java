package com.tour.dao.daoImpl;


import com.tour.dao.BaseDao;
import com.tour.dao.MessageboardDao;
import com.tour.domain.Messageboard;
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
@Repository("messageboardDaoImpl")
public class MessageboardDaoImpl implements MessageboardDao{

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
    public void save(Messageboard messageboard) throws DaoException {
        baseDao.save(messageboard);
    }

    @Override
    public List<Messageboard> findMessageByUserTel(String userTel) throws DaoException {
        String hql = "from Messageboard m where m.userTel = ?";
        String[] params = {userTel};
        List<Messageboard> listResultByHql = DaoUtil.getListResultByHql(getSession(), hql, params);

        return listResultByHql;
    }

}
