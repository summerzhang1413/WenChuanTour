package com.tour.services;

import com.tour.domain.Share;
import com.tour.exception.DaoException;

import java.util.List;

/**
 * Created by Administrator on 2015/1/23.
 */
public interface ShareService {

    public void save(Share share) throws DaoException;

    public List<Share> findShareListByUserTel(String userTel) throws DaoException;

}
