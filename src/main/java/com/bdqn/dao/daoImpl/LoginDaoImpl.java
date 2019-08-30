package com.bdqn.dao.daoImpl;

import com.bdqn.dao.LoginDao;
import com.bdqn.entity.NewsUsers;
import com.bdqn.until.BaseDao;

import java.sql.ResultSet;

public class LoginDaoImpl extends BaseDao implements LoginDao {
    @Override
    public ResultSet login(NewsUsers user) {
        String sql="SELECT `utype` FROM`news_users` WHERE uname=? AND upwd=?";
        Object[] paras={user.getUname(),user.getUpwd()};
        ResultSet rs = this.query(sql, paras);
        return rs;
    }
}
