package com.tour.dao;


import com.tour.domain.Messageboard;
import com.tour.exception.DaoException;

public interface MessageboardDao {

    public void save(Messageboard messageboard) throws DaoException;

}
