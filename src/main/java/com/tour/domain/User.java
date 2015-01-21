package com.tour.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2015/1/19.
 */
@Entity
@Table(name = "user", schema = "", catalog = "wenchuantour")
public class User extends BaseDomain{
    private int id;
    private String userTel;
    private String userName;
    private String longitude;
    private String latitude;
    private String friend;
    private String userPwd;
    private String isOnline;

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
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "longitude")
    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Basic
    @Column(name = "latitude")
    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Basic
    @Column(name = "friend")
    public String getFriend() {
        return friend;
    }

    public void setFriend(String friend) {
        this.friend = friend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (friend != null ? !friend.equals(user.friend) : user.friend != null) return false;
        if (latitude != null ? !latitude.equals(user.latitude) : user.latitude != null) return false;
        if (longitude != null ? !longitude.equals(user.longitude) : user.longitude != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (userTel != null ? !userTel.equals(user.userTel) : user.userTel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userTel != null ? userTel.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (friend != null ? friend.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "user_pwd")
    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Basic
    @Column(name = "isOnline")
    public String getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(String isOnline) {
        this.isOnline = isOnline;
    }
}
