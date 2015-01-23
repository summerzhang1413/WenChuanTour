package com.tour.services;


import com.tour.domain.Goodsorder;
import com.tour.exception.DaoException;

public interface GoodsOrderService {

    public void save(Goodsorder goodsorder) throws DaoException;

}
