package com.bdqn.entity;

import java.sql.ResultSet;
import java.util.List;

public class Page {
    private int pageSize;
    private int pageNum;
    private int pageCount;
    private ResultSet rs;
    private List list;

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }








}
