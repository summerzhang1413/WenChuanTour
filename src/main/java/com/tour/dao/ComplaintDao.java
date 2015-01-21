package com.tour.dao;


import com.tour.domain.Complaint;
import com.tour.exception.DaoException;

public interface ComplaintDao {

    public void save(Complaint complaint) throws DaoException;
}
