package com.tour.dao.daoImpl;


import com.tour.dao.BaseDao;
import com.tour.dao.ShareDao;
import com.tour.domain.Share;
import com.tour.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("shareDaoImpl")
public class ShareDaoImpl implements ShareDao{

    @Autowired
    private BaseDao baseDao;

    @Override
    public void save(Share share) throws DaoException {
        baseDao.save(share);
    }
}
