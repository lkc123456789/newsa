package com.bdqn.dao.daoImpl;

import com.bdqn.dao.DeleteDao;
import com.bdqn.until.BaseDao;

import java.util.Objects;

public class DeleteDaoImpl extends BaseDao implements DeleteDao {
    @Override
    public int deleteById(int id) {
        Object[] paras={id};
        String sql=" DELETE FROM `news` WHERE nid=?";
        int x=  this.update(sql,paras);
        return x;
    }
    public int deleteComById(int id){
        Object[] paras={id};
        String sql=" DELETE FROM `comments` WHERE nid=?";
        int x=  this.update(sql,paras);
        return x;

    }
}

