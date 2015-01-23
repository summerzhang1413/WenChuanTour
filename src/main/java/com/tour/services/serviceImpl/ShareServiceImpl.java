package com.tour.services.serviceImpl;

import com.tour.dao.ShareDao;
import com.tour.domain.Share;
import com.tour.exception.DaoException;
import com.tour.services.ShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("shareServiceImpl")
public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareDao shareDao;

    @Override
    public void save(Share share) throws DaoException {
        shareDao.save(share);
    }
}
