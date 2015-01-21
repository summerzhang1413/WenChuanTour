package com.tour.exception;

/**
 * Created by Administrator on 2015/1/20.
 */
public class DaoException extends Exception {

    public DaoException(){
        super("数据库交互异常");
    }
}
