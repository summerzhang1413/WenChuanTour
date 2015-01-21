package com.tour.util;


import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class DaoUtil {

    public static List getListResultByHql(Session session, String hql, String[] params){
        Query query = session.createQuery(hql);
        for (int i = 0; i < params.length; i ++){
            query.setParameter(i, params[i]);
        }
        return query.list();
    }

    public static boolean isNullForList(List list){
        if (list == null || list.size() == 0){
            return true;
        }else {
            return false;
        }
    }

}
