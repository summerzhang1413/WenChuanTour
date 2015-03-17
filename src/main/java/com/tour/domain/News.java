package com.tour.domain;

import javax.persistence.*;

/**
 * Created by Administrator on 2015/3/17.
 */
@Entity
@Table(name = "news", schema = "", catalog = "wenchuantour")
public class News extends BaseDomain{
    private int id;
    private String newsTitle;
    private String newsTime;
    private String newsContent;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "news_title")
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Basic
    @Column(name = "news_time")
    public String getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(String newsTime) {
        this.newsTime = newsTime;
    }

    @Basic
    @Column(name = "news_content")
    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (newsContent != null ? !newsContent.equals(news.newsContent) : news.newsContent != null) return false;
        if (newsTime != null ? !newsTime.equals(news.newsTime) : news.newsTime != null) return false;
        if (newsTitle != null ? !newsTitle.equals(news.newsTitle) : news.newsTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (newsTitle != null ? newsTitle.hashCode() : 0);
        result = 31 * result + (newsTime != null ? newsTime.hashCode() : 0);
        result = 31 * result + (newsContent != null ? newsContent.hashCode() : 0);
        return result;
    }
}
