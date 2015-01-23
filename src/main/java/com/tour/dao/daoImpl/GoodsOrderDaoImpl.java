package com.tour.dao.daoImpl;

import com.tour.dao.BaseDao;
import com.tour.dao.GoodsOrderDao;
import com.tour.domain.Goodsorder;
import com.tour.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("goodsOrderDaoImpl")
public class GoodsOrderDaoImpl implements GoodsOrderDao {

    @Autowired
    private BaseDao baseDao;

    @Override
    public void save(Goodsorder goodsorder) throws DaoException {
        baseDao.save(goodsorder);
    }

}
