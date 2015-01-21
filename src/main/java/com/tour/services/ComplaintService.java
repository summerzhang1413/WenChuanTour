package com.tour.services;


import com.tour.domain.Complaint;
import com.tour.exception.DaoException;

public interface ComplaintService {

    public void save(Complaint complaint) throws DaoException;

}
