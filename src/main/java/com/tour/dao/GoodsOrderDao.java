package com.tour.dao;


import com.tour.domain.Goodsorder;
import com.tour.exception.DaoException;

public interface GoodsOrderDao {

    public void save(Goodsorder goodsorder) throws DaoException;
}
