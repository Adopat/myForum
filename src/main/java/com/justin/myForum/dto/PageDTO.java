package com.justin.myForum.dto;

import java.util.List;

public class PageDTO<T> {
    // 当前页码
    private int pageNum;
    // 每页显示的条数
    private int pageSize;

    // 总条数
    private int totalRecord;
    //总条数
    private int totalPage;
    private List<T> list;
    public PageDTO(int pageNum,int pageSize,int totalRecord){
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;
        // 计算总页数
        if(totalRecord%pageSize==0){
            totalPage = totalRecord/pageSize;
        }else{
            totalPage = totalRecord/pageSize + 1;
        }

    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", list=" + list +
                '}';
    }
}
