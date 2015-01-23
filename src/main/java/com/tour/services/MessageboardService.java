package com.tour.services;


import com.tour.domain.Messageboard;
import com.tour.exception.DaoException;

public interface MessageboardService {


    public void save(Messageboard messageboard) throws DaoException;

}
