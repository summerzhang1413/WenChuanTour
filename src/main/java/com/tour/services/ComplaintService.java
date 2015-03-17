package com.tour.services;


import com.tour.domain.Complaint;
import com.tour.exception.DaoException;

import java.util.List;

public interface ComplaintService {

    public void save(Complaint complaint) throws DaoException;

    public List<Complaint> findComplaintByUserTel(String userTel) throws DaoException;

}
