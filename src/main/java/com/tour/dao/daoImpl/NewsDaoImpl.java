package com.tour.dao.daoImpl;

import com.tour.dao.NewsDao;
import com.tour.domain.News;
import com.tour.exception.DaoException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by Administrator on 2015/3/17.
 */
@Transactional
@Repository("newsDaoImpl")
public class NewsDaoImpl implements NewsDao {

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
    public List<News> findTheLast8() throws DaoException {
        String hql = "from News n order by n.id desc";
        Query query = getSession().createQuery(hql);
        query.setFirstResult(0);
        query.setMaxResults(8);
        List<News> list = query.list();
        return list;
    }
}
