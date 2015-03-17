package com.tour.services;

import com.tour.domain.News;
import com.tour.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2015/3/17.
 */
public interface NewsService {

    public List<News> findTheLast8() throws DaoException;

}
