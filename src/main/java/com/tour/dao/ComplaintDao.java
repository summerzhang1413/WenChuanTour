package com.tour.dao;


import com.tour.domain.Complaint;
import com.tour.exception.DaoException;

import java.util.List;

public interface ComplaintDao {

    public void save(Complaint complaint) throws DaoException;

    public List<Complaint> findComplaintByUserTel(String userTel) throws DaoException;

}
