package com.tour.dao;


import com.tour.domain.Goodsorder;
import com.tour.exception.DaoException;

import java.util.List;

public interface GoodsOrderDao {

    public void save(Goodsorder goodsorder) throws DaoException;

    public List<Goodsorder> findAllGoodsOrderByUserTel(String userTel) throws DaoException;

}
