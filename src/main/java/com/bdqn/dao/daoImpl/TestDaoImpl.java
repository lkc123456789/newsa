package com.bdqn.dao.daoImpl;

import com.bdqn.dao.TestDao;
import com.bdqn.entity.Page;
import com.bdqn.until.BaseDao;

import java.sql.ResultSet;
import java.util.List;

public class TestDaoImpl extends BaseDao implements TestDao {
    @Override
    public Page selectAll(Page page) {
         String sql="SELECT `nid`,`ntitle`,nauthor,`ncreateDate` FROM `news`";
        Page page1= this.page(sql,page);
        return page1;
    }

    @Override
    public ResultSet selectChain() {
        String sql="SELECT `nid`,`ntitle` FROM `news` WHERE `ntid`=1 limit 5;";
        ResultSet rs = this.query(sql, null);
        return rs;
    }

    @Override
    public ResultSet selectForeign() {
        String sql="SELECT `nid`,`ntitle` FROM `news` WHERE `ntid`=2 limit 5;";
        ResultSet rs = this.query(sql, null);
        return rs;
    }

    @Override
    public ResultSet selectPlay() {
        String sql="SELECT `nid`,`ntitle` FROM `news` WHERE `ntid`=5 limit 5;";
        ResultSet rs = this.query(sql, null);
        return rs;
    }

    @Override
    public ResultSet selectById(int id) {
        String sql= "SELECT `nid`,`ntid`, `ntitle`,`nauthor`,`ncreateDate`,`npicPath`,`ncontent`,`nmodifyDate`,`nsummary`FROM `news` WHERE `nid`=?";
        Object[] paras={id};
        ResultSet rs = this.query(sql, paras);
        return rs;
    }
}
