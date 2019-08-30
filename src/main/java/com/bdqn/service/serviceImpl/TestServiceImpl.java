package com.bdqn.service.serviceImpl;

import com.bdqn.dao.TestDao;
import com.bdqn.dao.daoImpl.TestDaoImpl;
import com.bdqn.entity.IndexAll;
import com.bdqn.entity.News;
import com.bdqn.entity.Page;
import com.bdqn.service.TestService;
import com.bdqn.until.BaseDao;


import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestServiceImpl extends BaseDao implements TestService {
    TestDao testDao=new TestDaoImpl();
    @Override
    public IndexAll selectAll(Page page) {
        List list=new ArrayList();
        List list1=new ArrayList();
        List list2=new ArrayList();
        List list3=new ArrayList();

        IndexAll indexAll=new IndexAll();

        Page page1=testDao.selectAll(page);
        ResultSet rs=page1.getRs();
        try {
            while(rs.next()){
               int nid=rs.getInt("nid");
               String ntitle=rs.getString("ntitle");
                String nauthor = rs.getString("nauthor");
                Date ncreateDate=rs.getTimestamp("ncreateDate");
                News news=new News();
                news.setNid(nid);
                news.setNtitle(ntitle);
                news.setNcreateDate(ncreateDate);
                news.setNauthor(nauthor);

                list.add(news);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        page1.setRs(null);
        page1.setList(list);
        ResultSet rs1=testDao.selectChain();
        try {
            while (rs1.next()){
                News news=new News();
                int nId = rs1.getInt("nId");
                String ntitle = rs1.getString("ntitle");
                news.setNid(nId);
                news.setNtitle(ntitle);
                list1.add(news);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs2=testDao.selectForeign();
        try {
            while (rs2.next()){
                News news=new News();
                int nId = rs2.getInt("nId");
                String ntitle = rs2.getString("ntitle");
                news.setNid(nId);
                news.setNtitle(ntitle);
                list2.add(news);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ResultSet rs3=testDao.selectPlay();
        try {
            while (rs3.next()){
                News news=new News();
                int nId = rs3.getInt("nId");
                String ntitle = rs3.getString("ntitle");
                news.setNid(nId);
                news.setNtitle(ntitle);
                list3.add(news);


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        this.destory();
        indexAll.setPage(page1);
        indexAll.setList1(list1);
        indexAll.setList2(list2);
        indexAll.setList3(list3);
        return indexAll;
    }

    @Override
    public News selectById(String id) {
        News news=new News();
        int id1=Integer.parseInt(id);

        ResultSet rs =testDao.selectById(id1);
        try {
            while (rs.next()){
                int nid= rs.getInt("nid");
                int ntid = rs.getInt("ntid");
                String ntitle = rs.getString("ntitle");
                String nauthor = rs.getString("nauthor");
                String nsummary = rs.getString("nsummary");
                String ncontent = rs.getString("ncontent");
                String npicPath = rs.getString("npicPath");
                Date ncreateDate = rs.getTimestamp("ncreateDate");
                Date nmodifyDate = rs.getTimestamp("nmodifyDate");

                news.setNid(nid);
                news.setNtid(ntid);
                news.setNtitle(ntitle);
                news.setNcreateDate(ncreateDate);
                news.setNauthor(nauthor);
                news.setNcontent(ncontent);
                news.setNsummary(nsummary);
                news.setNpicPath(npicPath);
                news.setNmodifyDate(nmodifyDate);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return news;
    }

}
