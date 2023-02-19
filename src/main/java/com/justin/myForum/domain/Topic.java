package com.justin.myForum.domain;

import java.util.Date;

/*
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `c_id` int(11) DEFAULT NULL COMMENT '分类',
  `title` varchar(128) DEFAULT NULL COMMENT '标题',
  `content` varchar(1024) DEFAULT NULL COMMENT '内容',
  `pv` int(11) DEFAULT NULL COMMENT '浏览量',
  `user_id` int(11) DEFAULT NULL,
  `username` varchar(64) DEFAULT NULL,
  `user_img` varchar(128) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `hot` int(2) DEFAULT '0' COMMENT '是否热门 1是热门',
  `delete` int(11) DEFAULT '0' COMMENT '0是未删除，1是一件删除',
 */
public class Topic {
    private int id;
    private int cID;
    private String title;
    private String content;
    private int pv;
    private int userId;
    private String userName;
    private String userImg;
    private Date createTime;
    private Date updateTime;
    private int hot;
    private int delete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getcID() {
        return cID;
    }

    public void setcID(int cID) {
        this.cID = cID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPv() {
        return pv;
    }

    public void setPv(int pv) {
        this.pv = pv;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getHot() {
        return hot;
    }

    public void setHot(int hot) {
        this.hot = hot;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "id=" + id +
                ", cID=" + cID +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", pv=" + pv +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userImg='" + userImg + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", hot=" + hot +
                ", delete=" + delete +
                '}';
    }
}
