package com.tour.dao.daoImpl;


import com.tour.dao.BaseDao;
import com.tour.dao.ShareDao;
import com.tour.domain.Share;
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
@Repository("shareDaoImpl")
public class ShareDaoImpl implements ShareDao{

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
    public void save(Share share) throws DaoException {
        baseDao.save(share);
    }

    @Override
    public List<Share> findShareListByUserTel(String userTel) throws DaoException {
        String hql = "from Share s where s.toUserTel = ?";
        String[] params = {userTel};
        List<Share> listResultByHql = DaoUtil.getListResultByHql(getSession(), hql, params);
        if (DaoUtil.isNullForList(listResultByHql)){
            return null;
        }
        return listResultByHql;
    }
}
