package com.tour.services;


import com.tour.domain.Messageboard;
import com.tour.exception.DaoException;

import java.util.List;

public interface MessageboardService {


    public void save(Messageboard messageboard) throws DaoException;

    public List<Messageboard> findMessageByUserTel(String userTel) throws DaoException;

}
