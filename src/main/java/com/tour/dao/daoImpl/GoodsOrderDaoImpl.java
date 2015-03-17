package com.tour.dao.daoImpl;

import com.tour.dao.BaseDao;
import com.tour.dao.GoodsOrderDao;
import com.tour.domain.Goodsorder;
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
@Repository("goodsOrderDaoImpl")
public class GoodsOrderDaoImpl implements GoodsOrderDao {

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
    public void save(Goodsorder goodsorder) throws DaoException {
        baseDao.save(goodsorder);
    }

    @Override
    public List<Goodsorder> findAllGoodsOrderByUserTel(String userTel) throws DaoException {
        String hql = "from Goodsorder g where g.userTel = ?";
        String[] params = {userTel};
        List<Goodsorder> listResultByHql = DaoUtil.getListResultByHql(getSession(), hql, params);
        if (DaoUtil.isNullForList(listResultByHql)){
            return null;
        }
        return listResultByHql;
    }

}
