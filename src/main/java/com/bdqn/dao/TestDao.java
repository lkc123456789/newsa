package com.bdqn.dao;

import com.bdqn.entity.Page;

import java.sql.ResultSet;
import java.util.List;

public interface TestDao {
    public Page selectAll(Page page);
    public ResultSet selectChain();
    public ResultSet selectForeign();
    public ResultSet selectPlay();
    public ResultSet selectById(int id);

}
