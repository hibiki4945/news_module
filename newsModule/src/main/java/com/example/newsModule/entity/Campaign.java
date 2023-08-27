package com.example.newsModule.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "campaign")
public class Campaign {

    @Id
    @Column(name = "title")
    private String title;

    @Column(name = "sub_title")
    private String subTitle;

    @Column(name = "start_time")
    private String startTime;
    
    @Column(name = "end_time")
    private String endTime;

    @Column(name = "content")
    private String content;

    @Column(name = "sub_content")
    private String subContent;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSubContent() {
        return subContent;
    }

    public void setSubContent(String subContent) {
        this.subContent = subContent;
    }

    public Campaign() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Campaign(String title, String subTitle, String startTime, String endTime, String content, String subContent) {
        super();
        this.title = title;
        this.subTitle = subTitle;
        this.startTime = startTime;
        this.endTime = endTime;
        this.content = content;
        this.subContent = subContent;
    }

    @Override
    public String toString() {
        return "Campaign [title=" + title + ", subTitle=" + subTitle + ", startTime=" + startTime + ", endTime=" + endTime + ", content=" + content + ", subContent=" + subContent
               + "]";
    }
    
    
}









