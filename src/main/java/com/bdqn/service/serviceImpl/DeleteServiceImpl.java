package com.bdqn.service.serviceImpl;

import com.bdqn.dao.DeleteDao;
import com.bdqn.dao.daoImpl.DeleteDaoImpl;
import com.bdqn.service.DeleteService;

import com.bdqn.until.BaseDao;

public class DeleteServiceImpl extends BaseDao implements DeleteService {
    @Override
    public int deleteById(String id) {
        int id1=Integer.parseInt(id);
        DeleteDao deleteDao=new DeleteDaoImpl();
        int j=deleteDao.deleteComById(id1);


        int i = deleteDao.deleteById(id1);

        return i;
    }
}
