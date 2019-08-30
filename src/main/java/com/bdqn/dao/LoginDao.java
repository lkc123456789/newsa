package com.bdqn.dao;

import com.bdqn.entity.NewsUsers;

import java.sql.ResultSet;

public interface LoginDao {
    public ResultSet login(NewsUsers user);
}
