package com.tour.dao.daoImpl;


import com.tour.dao.BaseDao;
import com.tour.dao.MessageboardDao;
import com.tour.domain.Messageboard;
import com.tour.exception.DaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository("messageboardDaoImpl")
public class MessageboardDaoImpl implements MessageboardDao{

    @Autowired
    private BaseDao baseDao;

    @Override
    public void save(Messageboard messageboard) throws DaoException {
        baseDao.save(messageboard);
    }

}
