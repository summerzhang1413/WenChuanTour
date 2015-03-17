package com.tour.services.serviceImpl;

import com.tour.dao.NewsDao;
import com.tour.domain.News;
import com.tour.exception.DaoException;
import com.tour.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2015/3/17.
 */
@Service("newsServiceImpl")
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsDao newsDao;

    @Override
    public List<News> findTheLast8() throws DaoException{
        return newsDao.findTheLast8();
    }

}
