package com.tour.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/1/19.
 */
public class BaseDomain implements Serializable {
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }

}