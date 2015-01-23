package com.tour.services.serviceImpl;


import com.tour.dao.MessageboardDao;
import com.tour.domain.Messageboard;
import com.tour.exception.DaoException;
import com.tour.services.MessageboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("messageboardServiceImpl")
public class MessageboardServiceImpl implements MessageboardService{

    @Autowired
    private MessageboardDao messageboardDao;

    @Override
    public void save(Messageboard messageboard) throws DaoException {
        messageboardDao.save(messageboard);
    }

}
