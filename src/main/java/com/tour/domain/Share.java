package com.tour.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2015/1/23.
 */
@Entity
@Table(name = "share", schema = "", catalog = "wenchuantour")
public class Share extends BaseDomain{
    private int id;
    private String userTel;
    private String content;
    private String toUserTel;
    private String tag;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_tel")
    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "to_user_tel")
    public String getToUserTel() {
        return toUserTel;
    }

    public void setToUserTel(String toUserTel) {
        this.toUserTel = toUserTel;
    }

    @Basic
    @Column(name = "tag")
    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Share share = (Share) o;

        if (id != share.id) return false;
        if (content != null ? !content.equals(share.content) : share.content != null) return false;
        if (tag != null ? !tag.equals(share.tag) : share.tag != null) return false;
        if (toUserTel != null ? !toUserTel.equals(share.toUserTel) : share.toUserTel != null) return false;
        if (userTel != null ? !userTel.equals(share.userTel) : share.userTel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userTel != null ? userTel.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (toUserTel != null ? toUserTel.hashCode() : 0);
        result = 31 * result + (tag != null ? tag.hashCode() : 0);
        return result;
    }
}
