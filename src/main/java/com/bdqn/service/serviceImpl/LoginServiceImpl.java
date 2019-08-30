package com.bdqn.service.serviceImpl;


import com.bdqn.dao.LoginDao;
import com.bdqn.dao.daoImpl.LoginDaoImpl;
import com.bdqn.entity.NewsUsers;
import com.bdqn.service.LoginService;
import com.bdqn.until.BaseDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServiceImpl extends BaseDao implements LoginService {


    @Override
    public int login(NewsUsers user) {
        int x =-1;
        LoginDao loginDao=new LoginDaoImpl();
        ResultSet rs =loginDao.login(user);

        try {
            while (rs.next()){
                int utype =rs.getInt("utype");
                x=utype;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return x;
    }


}
