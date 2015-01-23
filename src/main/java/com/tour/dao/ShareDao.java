package com.tour.dao;

import com.tour.domain.Share;
import com.tour.exception.DaoException;


public interface ShareDao {

    public void save(Share share) throws DaoException;

}
