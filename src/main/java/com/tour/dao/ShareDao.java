package com.tour.dao;

import com.tour.domain.Share;
import com.tour.exception.DaoException;

import java.util.List;


public interface ShareDao {

    public void save(Share share) throws DaoException;

    public List<Share> findShareListByUserTel(String userTel) throws DaoException;

}
