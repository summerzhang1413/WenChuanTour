package com.tour.dao.daoImpl;

import com.tour.dao.BaseDao;
import com.tour.domain.BaseDomain;
import com.tour.exception.DaoException;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/1/20.
 */
@Repository("baseDaoImpl")
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao {

    @Resource(name="sessionFactory")
    public void setMySessionFactory(SessionFactory sessionFactory){
        super.setSessionFactory(sessionFactory);
    }

    @Override
    public void save(BaseDomain baseDomain) throws DaoException {
        getHibernateTemplate().save(baseDomain);
    }

    @Override
    public void delete(BaseDomain baseDomain) throws DaoException {
        getHibernateTemplate().delete(baseDomain);
    }

    @Override
    public void update(BaseDomain baseDomain) throws DaoException {
        getHibernateTemplate().update(baseDomain);
    }

    @Override
    public List find(String queryString) throws DaoException {
        return getHibernateTemplate().find(queryString);
    }
}
