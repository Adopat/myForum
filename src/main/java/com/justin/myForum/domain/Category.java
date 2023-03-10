package com.justin.myForum.domain;


import java.util.Date;
//import java.util.Date;


/*
`id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(128) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
 */
public class Category {
    private int id;
    private String name;
    private int weight;
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", createTime=" + createTime +
                '}';
    }
}
