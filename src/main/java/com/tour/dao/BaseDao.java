package com.tour.dao;

import com.tour.domain.BaseDomain;
import com.tour.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2015/1/20.
 */
public interface BaseDao {

    public void save(BaseDomain baseDomain) throws DaoException;

    public void delete(BaseDomain baseDomain) throws DaoException;

    public void update(BaseDomain baseDomain) throws DaoException;

    public List find(String queryString) throws DaoException;
}
