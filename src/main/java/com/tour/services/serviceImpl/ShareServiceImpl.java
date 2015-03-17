package com.tour.services.serviceImpl;

import com.tour.dao.ShareDao;
import com.tour.domain.Share;
import com.tour.exception.DaoException;
import com.tour.services.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("shareServiceImpl")
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareDao shareDao;

    @Override
    public void save(Share share) throws DaoException {
        shareDao.save(share);
    }

    @Override
    public List<Share> findShareListByUserTel(String userTel) throws DaoException {
        return shareDao.findShareListByUserTel(userTel);
    }
}
