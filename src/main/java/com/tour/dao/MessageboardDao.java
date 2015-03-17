package com.tour.dao;


import com.tour.domain.Messageboard;
import com.tour.exception.DaoException;

import java.util.List;

public interface MessageboardDao {

    public void save(Messageboard messageboard) throws DaoException;

    public List<Messageboard> findMessageByUserTel(String userTel) throws DaoException;

}
