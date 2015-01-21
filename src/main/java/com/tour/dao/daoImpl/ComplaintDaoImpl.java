package com.tour.dao.daoImpl;

import com.tour.dao.BaseDao;
import com.tour.dao.ComplaintDao;
import com.tour.domain.Complaint;
import com.tour.exception.DaoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Repository("complaintDaoImpl")
public class ComplaintDaoImpl implements ComplaintDao{

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
    public void save(Complaint complaint) throws DaoException {
        baseDao.save(complaint);
    }
}
