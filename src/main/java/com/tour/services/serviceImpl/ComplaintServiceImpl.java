package com.tour.services.serviceImpl;

import com.tour.dao.ComplaintDao;
import com.tour.domain.Complaint;
import com.tour.exception.DaoException;
import com.tour.services.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("complaintServiceImpl")
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintDao complaintDao;

    @Override
    public void save(Complaint complaint) throws DaoException {
        complaintDao.save(complaint);
    }

    @Override
    public List<Complaint> findComplaintByUserTel(String userTel) throws DaoException {
        return complaintDao.findComplaintByUserTel(userTel);
    }
}
