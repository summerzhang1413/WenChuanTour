package com.tour.services.serviceImpl;

import com.tour.dao.GoodsOrderDao;
import com.tour.domain.Goodsorder;
import com.tour.exception.DaoException;
import com.tour.services.GoodsOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("goodsOrderServiceImpl")
public class GoodsOrderServiceImpl implements GoodsOrderService {

    @Autowired
    private GoodsOrderDao goodsOrderDao;

    @Override
    public void save(Goodsorder goodsorder) throws DaoException {
        goodsOrderDao.save(goodsorder);
    }

}
