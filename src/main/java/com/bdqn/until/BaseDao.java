package com.bdqn.until;

import com.bdqn.entity.Page;

import java.sql.*;

public class BaseDao {
    Connection connection=null;
    ResultSet rs=null;
    PreparedStatement pst=null;
    public Connection getCon(){

       String Driver= ConfigManager.getConfigManager().getpro("driver");
       String url= ConfigManager.getConfigManager().getpro("url");
       String username= ConfigManager.getConfigManager().getpro("username");
       String password= ConfigManager.getConfigManager().getpro("password");
        try {
            Class.forName(Driver);
            connection= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
public ResultSet  query(String sql ,Object[] paras){
    getCon();
    try {
        pst=connection.prepareStatement(sql);
        if(paras!=null){
            for(int i=0;i<paras.length;i++){
                pst.setObject(i+1,paras[i]);
            }

        }
        rs=pst.executeQuery();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return  rs;
}
    public int update(String sql ,Object[] paras){
        getCon();
        int x=0;
        try {
            pst=connection.prepareStatement(sql);
            if(paras!=null){
                for(int i=0;i<paras.length;i++){
                    pst.setObject(i+1,paras[i]);
                }

            }
            x=pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return x;
    }
    public void destory(){
        //关闭结果集
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //关闭sql预处理
        if(pst!=null){
            try {
                pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //关闭连接
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public Page page(String sql, Page page){
        getCon();
        ResultSet rs =null;
        int count =0;
        int pageCount=0;
        Integer pageNum=0;
        String pageSql = sql+" LIMIT ?,?";
        String countSql = "SELECT COUNT(*) count  FROM ("+sql+")a ";

        //sql预处理对象
        PreparedStatement pst = null;



        try {

            //总页数
            pst = connection.prepareStatement(countSql);
            ResultSet rsCount =pst.executeQuery();
            while (rsCount.next()){
                count =rsCount.getInt("count");
            }
            if((count%page.getPageSize())==0){
                pageCount = count/page.getPageSize();
            }else {
                pageCount = count/page.getPageSize() +1;
            }

            pageNum =page.getPageNum();
            if(pageNum>pageCount){
                pageNum = pageCount;
            }
            Integer pageStart =
                   page.getPageSize()*(pageNum-1);
            Object[] pars = {pageStart,page.getPageSize()};
            pst = connection.prepareStatement(pageSql);
            //pst.setString(1,user.getName());
            //pst.setString(2,user.getPwd());
            if(pars != null){
                for(int i =0 ;i<pars.length;i++){
                    pst.setObject(i+1,pars[i]);
                }
            }
            rs = pst.executeQuery();



        } catch (SQLException e) {
            e.printStackTrace();
        }
        Page page1 = new Page();
        page1.setPageCount(pageCount);
        page1.setRs(rs);
        page1.setPageNum(pageNum);

        return page1;
    }

    public static void main(String[] args) {
        BaseDao baseDao=new BaseDao();
        System.out.println(baseDao.getCon());
    }
}
